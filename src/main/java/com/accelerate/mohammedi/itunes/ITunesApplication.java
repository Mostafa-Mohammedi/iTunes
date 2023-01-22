package com.accelerate.mohammedi.itunes;

import com.accelerate.mohammedi.itunes.service.CustomerImplementation;
import com.accelerate.mohammedi.itunes.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ITunesApplication implements ApplicationRunner {

	@Autowired
	CustomerImplementation studentService;
	public static void main(String[] args) {
		SpringApplication.run(ITunesApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//studentService.getAll();
		//studentService.getById(10);
		//studentService.getByName("Daan");

		/*
		studentService.create(new Customer(61,
				"Mostafa",
				"Mohammedi",
				"Norway",
				"1151",
				"95242854",
				"mosti94@hotmail.com"));
		 */

		studentService.update(new Customer(61,
				"Smane",
				"Mohammedi",
				"Norway",
				"1151",
				"91847087",
				"smane96@hotmail.com"));

	}
}
