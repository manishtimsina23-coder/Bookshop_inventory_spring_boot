package com.bookshopinventory.demo.Converter;

import com.bookshopinventory.demo.DTO.OrderDTO;
import com.bookshopinventory.demo.model.Customer;
import com.bookshopinventory.demo.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO toDTO(Order order){
        OrderDTO orderdto = new OrderDTO();
        orderdto.setId(order.getId());
        orderdto.setCustomerId(order.getCustomer().getId());
        orderdto.setOrderDate(order.getPurchaseDate());
        return orderdto;
    }

    public Order toEntity(Order orderdto){
        Order order = new Order();
        order.setId(orderdto.getId());
        //order.setCustomer(orderdto.getCustomerId());
        order.setPurchaseDate(orderdto.getPurchaseDate());
        return order;
    }
}
