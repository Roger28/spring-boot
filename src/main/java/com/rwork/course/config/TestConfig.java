package com.rwork.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rwork.course.entities.Category;
import com.rwork.course.entities.Order;
import com.rwork.course.entities.OrderItem;
import com.rwork.course.entities.Product;
import com.rwork.course.entities.User;
import com.rwork.course.entities.enums.OrderStatus;
import com.rwork.course.repositories.CategoryRepository;
import com.rwork.course.repositories.OrderItemRepository;
import com.rwork.course.repositories.OrderRepository;
import com.rwork.course.repositories.ProductRepository;
import com.rwork.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Computers");
		Category c3 = new Category(null, "Books");
		Category c4 = new Category(null, "IOT");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		this.categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		this.productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(c2);
		p1.getCategories().add(c4);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		this.productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User roger = new User(null, "Roger", "roger@gmail.com", "9999-9999", "root");
		User nana = new User(null, "Nana", "nana@gmail.com", "8888-8888", "123");

		Order o1 = new Order(null, Instant.parse("2019-11-22T17:45:09Z"), OrderStatus.PAID, roger);
		Order o2 = new Order(null, Instant.parse("2015-11-01T10:45:09Z"), OrderStatus.WAITING_PAYMENT, nana);
		Order o3 = new Order(null, Instant.parse("2010-11-15T12:45:09Z"), OrderStatus.CANCELED, roger);

		this.userRepository.saveAll(Arrays.asList(roger, nana));
		this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		this.orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
}
