package com.rwork.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rwork.course.entities.User;
import com.rwork.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		User roger = new User(null, "Roger", "roger@gmail.com", "9999-9999", "root");
		User nana = new User(null, "Nana", "nana@gmail.com", "8888-8888", "123");

		this.repository.saveAll(Arrays.asList(roger, nana));
	}

	@Autowired
	private UserRepository repository;
}
