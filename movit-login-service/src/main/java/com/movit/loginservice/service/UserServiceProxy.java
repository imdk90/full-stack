package com.movit.loginservice.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movit.loginservice.beans.UserResponseBean;
import com.movit.loginservice.service.fallbacks.UserServiceProxyFallback;

//@FeignClient(name = "movit-user-service", url = "localhost:8000")
@FeignClient(name = "movit-user-service", fallback = UserServiceProxyFallback.class)

//@FeignClient(name = "movit-user-service")
@RibbonClient(name = "movit-user-service")
public interface UserServiceProxy {

	@GetMapping("/user/{id}")
	public UserResponseBean getUserDetailsById(@PathVariable long id);

	@GetMapping("/user/{firstName}/{password}")
	public UserResponseBean getUserByFirstName(@PathVariable String firstName, @PathVariable String password);

	@GetMapping("/users")
	public List<UserResponseBean> getUsers();
}
