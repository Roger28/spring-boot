package com.rwork.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwork.course.entities.User;
import com.rwork.course.repositories.UserRepository;
import com.rwork.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	public List<User> findAll() {
		return this.repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = this.repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return this.repository.save(user);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User user = this.repository.getOne(id);
		updateData(user, obj);
		return this.repository.save(user);
	}

	private void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		user.setPhone(obj.getPhone());
	}

	@Autowired
	private UserRepository repository;
}
