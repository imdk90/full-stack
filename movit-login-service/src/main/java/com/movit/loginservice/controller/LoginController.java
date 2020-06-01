package com.movit.loginservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movit.loginservice.beans.UserResponseBean;
import com.movit.loginservice.service.UserServiceProxy;

@RestController
@CrossOrigin(origins = "http://localhost:8500")
public class LoginController {

	private ResponseEntity<UserResponseBean> responseEntity;
	@Autowired
	private UserServiceProxy proxy;

	/*
	 * @Autowired private UserServiceByNameProxy proxyByName;
	 */
	/*
	 * @GetMapping("/user/login/{id}/{password}") public UserResponseBean
	 * loginUserByUsingRestController(@PathVariable long id, @PathVariable String
	 * password) {
	 * 
	 * Map<String, Long> uriVariable = new HashMap<String, Long>();
	 * uriVariable.put("id", id); responseEntity = new
	 * RestTemplate().getForEntity("http://localhost:8000/user/{id}",
	 * UserResponseBean.class, uriVariable); UserResponseBean userBean =
	 * responseEntity.getBody(); if (userBean != null) {
	 * userBean.setMessage("Success"); } return userBean; }
	 */

	@GetMapping("/user/login-feign/{id}/{password}")
	public UserResponseBean loginUserByUsingFeign(@PathVariable long id, @PathVariable String password) {
		UserResponseBean userBean = proxy.getUserDetailsById(id);
		if (userBean != null) {
			userBean.setMessage("Success");
		}
		return userBean;
	}

	@GetMapping("/user/login/{firstName}/{password}")
	public UserResponseBean loginUserByName(@PathVariable String firstName, @PathVariable String password) {
		UserResponseBean userBean = proxy.getUserByFirstName(firstName, password);
		if (userBean != null) {
			userBean.setMessage("Success");
		}
		return userBean;
	}

	@GetMapping("/users")
	public List<UserResponseBean> retriveUsers() {
		return proxy.getUsers();
	}

	@GetMapping("/user/{userName}")
	public UserResponseBean getUserDetails(@PathVariable String userName) {
		UserResponseBean userResponse = proxy.getUsers().stream()
				.filter(user -> user.getFirstName().equalsIgnoreCase(userName)).findAny().orElse(null);
		return userResponse;
	}
}
