package com.bookshopinventory.demo.Service;


import com.bookshopinventory.demo.Repository.CustomerRepository;
import com.bookshopinventory.demo.Repository.OrderRepository;
import com.bookshopinventory.demo.model.Customer;
import com.bookshopinventory.demo.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;


    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Order addOrder(Order order,Long customerid) {
        Customer customer = customerRepository.findById(customerid).orElse(null);
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

}
