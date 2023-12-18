package com.swa.ecommerce.dao;

import com.swa.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
// no lleva la anotacion @RepositoryRestResource por ende no sera expuesto la api
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // behind the scenes, spring will execute a query similar to this
    Customer findByEmail(String theEmail);
}
