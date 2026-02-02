package com.bookshopinventory.demo.Repository;

import com.bookshopinventory.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
