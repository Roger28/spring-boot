package com.rwork.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rwork.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
