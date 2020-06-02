package com.movit.serviceservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.boot.model.relational.AuxiliaryDatabaseObject.Expandable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movit.serviceservice.beans.User;
import com.movit.serviceservice.exception.UserNotFountException;
import com.movit.serviceservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(int id) {

		Optional<User> findById = userRepository.findById(id);

		return findById.get();

		/*
		 * User userById = userList.stream().filter(user -> user.getId() ==
		 * id).findAny().orElse(null);
		 * 
		 * if (userById != null) { return userById; }
		 */
	}

	public User findByFirstName(String firstName) {
		User userByFirstName = userRepository.findByFirstName(firstName);

		/*
		 * User userByFirstName = userList.stream().filter(user ->
		 * user.getFirstName().equalsIgnoreCase(firstName)) .findAny().orElse(null);
		 */
		if (userByFirstName != null) {
			return userByFirstName;
		}
		return null;
	}
}
