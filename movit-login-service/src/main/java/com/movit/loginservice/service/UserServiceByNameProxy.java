package com.movit.loginservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.movit.loginservice.beans.UserResponseBean;
import com.movit.loginservice.service.fallbacks.UserServiceProxyFallback;

/*
@FeignClient(name = "movit-user-service", fallback = UserServiceProxyFallback.class)
@RibbonClient(name = "movit-user-service")*/
public interface UserServiceByNameProxy {
	/*
	 * @GetMapping("/user/{name}") public UserResponseBean
	 * getUserByFirstName(@PathVariable String firstName);
	 */
}
