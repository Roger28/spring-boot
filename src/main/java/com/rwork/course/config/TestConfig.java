package com.rwork.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rwork.course.entities.Category;
import com.rwork.course.entities.Order;
import com.rwork.course.entities.User;
import com.rwork.course.entities.enums.OrderStatus;
import com.rwork.course.repositories.CategoryRepository;
import com.rwork.course.repositories.OrderRepository;
import com.rwork.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Computers");
		Category c3 = new Category(null, "Books");

		this.categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

		User roger = new User(null, "Roger", "roger@gmail.com", "9999-9999", "root");
		User nana = new User(null, "Nana", "nana@gmail.com", "8888-8888", "123");

		Order o1 = new Order(null, Instant.parse("2019-11-22T17:45:09Z"), OrderStatus.PAID, roger);
		Order o2 = new Order(null, Instant.parse("2015-11-01T10:45:09Z"), OrderStatus.WAITING_PAYMENT, nana);
		Order o3 = new Order(null, Instant.parse("2010-11-15T12:45:09Z"), OrderStatus.CANCELED, roger);

		this.userRepository.saveAll(Arrays.asList(roger, nana));
		this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
}
