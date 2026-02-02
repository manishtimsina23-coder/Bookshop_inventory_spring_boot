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
        this.orderItemMapper = new OrderItemMapper();
    }

    @PostMapping("/{orderid}/{bookid}")
    public ResponseEntity<OrderItemDTO> addOrderItem(@RequestBody OrderItem orderitem, @PathVariable Long orderid, @PathVariable Long bookid){
        OrderItem order = orderItemMapper.toEntity(orderitem);
        OrderItem savedorder = orderItemService.addOrderItem(order,orderid,bookid);
        return ResponseEntity.ok(orderItemMapper.toDTO(savedorder));
    }
}
