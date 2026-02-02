package com.bookshopinventory.demo.Controller;

import com.bookshopinventory.demo.Converter.OrderItemMapper;
import com.bookshopinventory.demo.DTO.OrderItemDTO;
import com.bookshopinventory.demo.Service.OrderItemService;
import com.bookshopinventory.demo.model.Order;
import com.bookshopinventory.demo.model.OrderItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderitem")
public class OrderItemController {
    private OrderItemService orderItemService;
    private OrderItemMapper orderItemMapper;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping("/{orderid}")
    public ResponseEntity<OrderItemDTO> addOrderItem(@RequestBody OrderItem orderitem, @PathVariable Long orderid){
        OrderItem order = orderItemMapper.toEntity(orderitem);
        OrderItem savedorder = orderItemService.addOrderItem(order,orderid);
        return ResponseEntity.ok(orderItemMapper.toDTO(savedorder));
    }
}
