package com.rwork.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwork.course.entities.Product;
import com.rwork.course.repositories.ProductRepository;

@Service
public class ProductService {

	public List<Product> findAll() {
		return this.repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> product = this.repository.findById(id);
		return product.get();
	}

	@Autowired
	private ProductRepository repository;
}
