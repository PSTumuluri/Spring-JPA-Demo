package com.example.accessingdatajpa;

// The following imports let you use tags that are used by Spring to
// automatically map each Java class to a database table.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Entity tag lets JPA know to create a table called Customer.
@Entity
public class Customer {

	// Id tag ensures that this attribute is used as the PK of the table.
	// GeneratedValue tag lets JPA know to automaticall generate the next
	// ID whenever a new Customer is created.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;

	/* 
	 * Two constructors need to be defined for each entity class:
	 * 1. An empty do-nothing constructor; this one used internally by
	 * JPA, hence is declared protected. Should not be called by you.
	 * 2. The actual constructor used to create new instances of Customer
	 * based on the required fields.
	 */
	protected Customer() { }
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Useful for debugging and command-line demo.
	@Override
	public String toString() {
		return String.format(
			"Customer[id=%d, firstName='%s', lastName='%s']",
			id, firstName, lastName);
	}

	// Unlike C#, this trash language makes you write all of this.
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
}
