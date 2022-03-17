package com.example.accessingdatajpa;

// The following two imports let us log messages to the command line.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The following two imports let us create a command line demo and return it as
// a Bean that gets automatically run when the application launches.
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log =
		LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}
	
	// Two main points here:
	// 1. The parameter to this method is a parameterized CrudRepository
	// (in this case, our CustomerRepository). This will be used in the
	// method body to access the corresponding table.
	// 2. The return value of this method is a functional interface in the
	// form of a lambda expression. This lamda defines the statements to
	// be executed by the system when the application starts.
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// Add tuples to the table.
			repository.save(new Customer("Pavan", "Tumuluri"));
			repository.save(new Customer("Yerim", "Roh"));
			repository.save(new Customer("Josh", "Fonseca"));
			
			// findAll() returns an iterable collection of 
			// all tuples.
			log.info("Customers found with findAll():");
			log.info("------------------------------");
			for (Customer customer: repository.findAll()) {
				log.info(customer.toString());
			}

			// Access tuple by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("---------------------------------");
			log.info(customer.toString());
			log.info("");

			// As an alternative to writing the iteration yourself,
			// call the forEach method of the collection and pass
			// it a lambda specifying an instance of the Consumer
			// functional interface.
			log.info("Customer found with findByLastName('Roh'):");
			log.info("------------------------------------------");
			repository.findByLastName("Roh").forEach(cust -> {
				log.info(cust.toString());
			});

			log.info("");
		};
	}
}
