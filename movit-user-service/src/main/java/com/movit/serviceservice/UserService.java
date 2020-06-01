package com.movit.serviceservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movit.serviceservice.beans.User;

@Service
public class UserService {

	private static List<User> userList = new ArrayList<User>();
	static {
		userList.add(new User(1l, "Mayur", "Khairnar", "123"));
		userList.add(new User(2l, "Rajendra", "Patil", "123"));
		userList.add(new User(3l, "Praful", "Sonwane", "123"));
		userList.add(new User(4l, "Mahesh", "Kantekure", "Mahesh Babu"));
		userList.add(new User(5l, "Prabhat", "Singh", "123"));
		userList.add(new User(6l, "Pradip", "Yadav", "123"));
		userList.add(new User(7l, "Chinmay", "Kharote", "123"));
		userList.add(new User(8l, "Jagnnath", "Kale", "123"));
		userList.add(new User(9l, "Amol", "Devkar", "123"));
	}

	public List<User> findAll() {
		return userList;
	}

	public User findById(long id) {

		User userById = userList.stream().filter(user -> user.getId() == id).findAny().orElse(null);

		if (userById != null) {
			return userById;
		}
		return null;
	}

	public User findByFirstName(String firstName) {
		User userByFirstName = userList.stream().filter(user -> user.getFirstName().equalsIgnoreCase(firstName))
				.findAny().orElse(null);
		if (userByFirstName != null) {
			return userByFirstName;
		}
		return null;
	}
}
