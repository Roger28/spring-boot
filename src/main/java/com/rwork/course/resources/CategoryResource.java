package com.rwork.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rwork.course.entities.Category;
import com.rwork.course.services.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/categories")
public class CategoryResource {

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> users = this.service.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category category = this.service.findById(id);
		return ResponseEntity.ok().body(category);
	}

	@Autowired
	private CategoryService service;
}
