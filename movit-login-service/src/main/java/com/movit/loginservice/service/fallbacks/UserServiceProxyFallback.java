package com.movit.loginservice.service.fallbacks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.movit.loginservice.beans.UserResponseBean;
import com.movit.loginservice.service.UserServiceProxy;

@Component
public class UserServiceProxyFallback implements UserServiceProxy {

	@Autowired
	private Environment environment;

	@Override
	public UserResponseBean getUserDetailsById(int id) {
		return new UserResponseBean(1l, "Default", "default", "123",
				(Integer.parseInt(environment.getProperty("local.server.port"))));

	}

	@Override
	public UserResponseBean getUserByFirstName(String firstName, String password) {
		return new UserResponseBean(1l, "Default", "default", "123",
				(Integer.parseInt(environment.getProperty("local.server.port"))));
	}

	@Override
	public List<UserResponseBean> getUsers() {

		return new ArrayList<UserResponseBean>();
	}

	@Override
	public UserResponseBean getUserByName(String firstName) {
		return new UserResponseBean(1l, "Default", "default", "123",
				(Integer.parseInt(environment.getProperty("local.server.port"))));
	}

}
