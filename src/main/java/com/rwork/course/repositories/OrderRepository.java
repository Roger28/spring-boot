package com.rwork.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rwork.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
