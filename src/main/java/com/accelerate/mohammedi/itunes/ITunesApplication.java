package com.accelerate.mohammedi.itunes;

import com.accelerate.mohammedi.itunes.chinookDAO.ChinoookDAO;
import com.accelerate.mohammedi.itunes.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ITunesApplication implements ApplicationRunner {
	@Autowired
	ChinoookDAO chinoookDAO;

	@Autowired
	Customer customer;
	public static void main(String[] args) {
		SpringApplication.run(ITunesApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		customer.read_All_Customer();
	}
}
