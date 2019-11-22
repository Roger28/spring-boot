package com.rwork.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwork.course.entities.Order;
import com.rwork.course.repositories.OrderRepository;

@Service
public class OrderService {

	public List<Order> findAll() {
		return this.repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> user = this.repository.findById(id);
		return user.get();
	}

	@Autowired
	private OrderRepository repository;
}
