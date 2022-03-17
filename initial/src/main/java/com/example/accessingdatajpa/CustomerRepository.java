package com.example.accessingdatajpa;

import java.util.List;

// The CrudRepository interface declares methods for accessing a JPA table.
// The entity and ID type that it works with are specified by generic 
// parameters.
 
import org.springframework.data.repository.CrudRepository;

// This interface declares how our application queries the DB for Customer
// entities. The implementation is generated by Spring at runtime.
// We would repeat this for, e.g. Movie, Show, etc.
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	Customer findById(long id);
}