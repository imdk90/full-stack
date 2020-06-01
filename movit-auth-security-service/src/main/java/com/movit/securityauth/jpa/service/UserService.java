package com.movit.securityauth.jpa.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movit.securityauth.model.User;
import com.movit.securityauth.repository.UserRepository;
import com.movit.securityauth.service.MovitUserService;

@Service
@Transactional
public class UserService implements MovitUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public Optional<User> findByName(String name) {
		return userRepository.findByName(name);
	}

}
