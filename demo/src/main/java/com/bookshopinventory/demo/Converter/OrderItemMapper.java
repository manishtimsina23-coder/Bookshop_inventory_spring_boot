package com.bookshopinventory.demo.Converter;

import com.bookshopinventory.demo.DTO.OrderItemDTO;
import com.bookshopinventory.demo.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {
    public OrderItemDTO toDTO(OrderItem orderItem) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setBookId(orderItem.getBook().getId());
        orderItemDTO.setOrderId(orderItem.getOrder().getId());
        return orderItemDTO;
    }

    public OrderItem toEntity(OrderItem orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDTO.getId());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setBook(orderItem.getBook());
        orderItem.setOrder(orderItem.getOrder());
        return orderItem;
    }
}
