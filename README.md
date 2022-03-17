# Accessing Data Guide

This is the source code for a demo of the JPA API for accessing the DB.
It covers the creation of Entity classes, the creation of a repository for
centralizing database access operations, and the creation of a demo program
for testing these entities and operations.

## Creating Entity Classes

Start in

    initial/src/main/java/com/example/accessingdatajpa/Customer.java

Here, you will find the definition of an entity class called Customer, as well
as comments explaining the essential parts of any entity class definition. 

## Creating a Repository For Your Entity

Proceed to

    initial/src/main/java/com/example/accessingdatajpa/CustomerRepository.java

where you will see the interface declaring the methods to be used by the
application to make queries.

## Logging and Demoing

Finally, go to

    initial/src/main/java/com/example/accessingdatajpa/
        AccessingDataJpaApplication.java

You should have already gone through the quickstart source code to understand
the general workflow of the application. In this file, I create a Logger to
log debug messages to the console. I also create a demo which calls
the methods declared in CustomerRepository, as well as those inherited from
the generic CrudRepository, and logs some messages to demonstrate. The demo
is run automatically by the system when we launch the application.
