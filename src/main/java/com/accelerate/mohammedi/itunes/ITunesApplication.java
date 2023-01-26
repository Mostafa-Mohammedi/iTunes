package com.accelerate.mohammedi.itunes;

import com.accelerate.mohammedi.itunes.models.Customer;
import com.accelerate.mohammedi.itunes.models.CustomerCountry;
import com.accelerate.mohammedi.itunes.models.CustomerGenre;
import com.accelerate.mohammedi.itunes.models.CustomerSpender;
import com.accelerate.mohammedi.itunes.service.CustomerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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
		//customerService.getAll();


		//Customer customer = customerService.getById(10);

		//Customer customer = customerService.getByName("Daan");

		//Customer customer = customerService.create(new Customer(63,"Mostafa","Mohammedi","Norway","1151","95242854","mosti94@hotmail.com"));
		//List<Customer> customer = customerService.pageCustomer(new Customer(), 10,20);



		//Customer customer = customerService.update(new Customer(62, "Smane", "Mohammedi", "Norway", "1151", "91847087", "smane96@hotmail.com"));

		//System.out.println(customer);
		//CustomerCountry customerCountry = customerService.countryMostCustomer();
		//System.out.println(customerCountry);
		//CustomerSpender customerSpender = customerService.customer_most_total();
		//System.out.println(customerSpender);

		// CustomerGenre cs = customerService.most_popularGenre(12);
		//System.out.println(cs);



	}


	}
