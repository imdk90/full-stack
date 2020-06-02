package com.movit.serviceservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movit.serviceservice.UserService;
import com.movit.serviceservice.beans.User;

@RestController
public class UserServiceController {

	@Autowired
	public UserService userService;

	@Autowired
	private Environment environment;

	@GetMapping("/user/{id}")
	public User getUserDetailsById(@PathVariable int id) {
		User findById = userService.findById(id);
		findById.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return findById;
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> users = userService.findAll();
		return users;
	}

	@GetMapping("/getUser/{firstName}")
	public User getUserByName(@PathVariable String firstName) {
		User userByName = userService.findByFirstName(firstName);
		userByName.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return userByName;
	}

	@GetMapping("/user/{firstName}/{password}")
	public User getUserByFirstName(@PathVariable String firstName, @PathVariable String password) {
		User userByName = userService.findByFirstName(firstName);
		userByName.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return userByName;
	}

}
