package com.rwork.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rwork.course.entities.Category;
import com.rwork.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	public List<Category> findAll() {
		return this.repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> user = this.repository.findById(id);
		return user.get();
	}

	@Autowired
	private CategoryRepository repository;
}
