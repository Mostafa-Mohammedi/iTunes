package com.accelerate.mohammedi.itunes;

import com.accelerate.mohammedi.itunes.models.Customer;
import com.accelerate.mohammedi.itunes.service.CustomerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ITunesApplication implements ApplicationRunner {

	final CustomerImplementation customerService;

	public ITunesApplication(CustomerImplementation customerService) {
		this.customerService = customerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ITunesApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		customerService.getAll();
		//customerService.getById(10);
		//customerService.getByName("Daan");

		//customerService.create(new Customer(62,"Mostafa","Mohammedi","Norway","1151","95242854","mosti94@hotmail.com"));
		//customerService.pageCustomer(new Customer(), 10,20);


		//customerService.update(new Customer(62, "Smane", "Mohammedi", "Norway", "1151", "91847087", "smane96@hotmail.com"));
		//customerService.countryMostCustomer();
		//customerService.customer_most_total();

		//Customer cs = customerService.most_popularGenre(12);
		//System.out.println(cs);



	}


	}
