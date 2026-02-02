package com.bookshopinventory.demo.Service;


import com.bookshopinventory.demo.Converter.OrderItemMapper;
import com.bookshopinventory.demo.Repository.OrderItemRepository;
import com.bookshopinventory.demo.model.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderItemService {
    private OrderItemRepository orderItemRepository;
    private OrderItemMapper orderItemMapper;
    public OrderItemService(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    public OrderItem addOrderItem(OrderItem orderItem, Long orderid) {
        

    }
}
