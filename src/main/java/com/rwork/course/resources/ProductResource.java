package com.rwork.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rwork.course.entities.Product;
import com.rwork.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> users = this.service.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product product = this.service.findById(id);
		return ResponseEntity.ok().body(product);
	}

	@Autowired
	private ProductService service;
}
