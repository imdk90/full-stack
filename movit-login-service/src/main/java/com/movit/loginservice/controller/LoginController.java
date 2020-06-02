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

	@GetMapping("/user/login-feign/{id}/{password}")
	public UserResponseBean loginUserByUsingFeign(@PathVariable int id, @PathVariable String password) {
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
		UserResponseBean userResponse = proxy.getUserByName(userName);
		if (userResponse != null) {
			userResponse.setMessage("Success");
		}
		return userResponse;
	}
}
