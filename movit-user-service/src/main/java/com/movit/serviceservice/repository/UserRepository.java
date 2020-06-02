package com.movit.serviceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movit.serviceservice.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByFirstName(String firstName);
}
