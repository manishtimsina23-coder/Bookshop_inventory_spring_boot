package com.bookshopinventory.demo.Controller;

import com.bookshopinventory.demo.Converter.AuthorMapper;
import com.bookshopinventory.demo.Converter.CustomerMapper;
import com.bookshopinventory.demo.DTO.CustomerDTO;
import com.bookshopinventory.demo.Service.CustomerService;
import com.bookshopinventory.demo.model.Customer;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;


    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody Customer customer){
        Customer custome = customerMapper.toEntity(customer);
        Customer savedCustomer = customerService.addCustomer(customer);
        return ResponseEntity.ok(customerMapper.toDTO(savedCustomer));
    }
}
