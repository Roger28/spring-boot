package com.rwork.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rwork.course.entities.Order;
import com.rwork.course.services.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/orders")
public class OrderResource {

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> orders = this.service.findAll();
		return ResponseEntity.ok().body(orders);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = this.service.findById(id);
		return ResponseEntity.ok().body(order);
	}

	@Autowired
	private OrderService service;
}
