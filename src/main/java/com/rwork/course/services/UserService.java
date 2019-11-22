package com.rwork.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwork.course.entities.User;
import com.rwork.course.repositories.UserRepository;

@Service
public class UserService {

	public List<User> findAll() {
		return this.repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = this.repository.findById(id);
		return user.get();
	}

	@Autowired
	private UserRepository repository;
}