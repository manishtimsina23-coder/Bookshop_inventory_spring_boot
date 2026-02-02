package com.bookshopinventory.demo.Service;

import com.bookshopinventory.demo.Repository.CustomerRepository;
import com.bookshopinventory.demo.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional   // @Transactional le chai purai transaction purai success na huda samma tyo database ma save hudaina purai success bhayo bhane matra database ma save hunxa
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
