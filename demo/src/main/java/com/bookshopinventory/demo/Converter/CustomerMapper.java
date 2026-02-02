package com.bookshopinventory.demo.Converter;

import com.bookshopinventory.demo.DTO.CustomerDTO;
import com.bookshopinventory.demo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerdto = new CustomerDTO();
        customerdto.setId(customer.getId());
        customerdto.setName(customer.getName());
        customerdto.setPhone(customer.getPhone());
        customerdto.setEmail(customer.getEmail());
        return customerdto;
    }

    public Customer toEntity(Customer customerdto) {
        Customer customer = new Customer();
        customer.setId(customerdto.getId());
        customer.setName(customerdto.getName());
        customer.setPhone(customerdto.getPhone());
        customer.setEmail(customerdto.getEmail());
        return customer;
    }
}
