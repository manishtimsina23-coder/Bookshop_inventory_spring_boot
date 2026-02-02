package com.bookshopinventory.demo.Controller;
import com.bookshopinventory.demo.Converter.CustomerMapper;
import com.bookshopinventory.demo.Converter.OrderMapper;
import com.bookshopinventory.demo.DTO.OrderDTO;
import com.bookshopinventory.demo.Service.OrderService;
import com.bookshopinventory.demo.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
public class OrderController {
    private final OrderMapper orderMapper;
    private OrderService orderService;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping("/{customerid}")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody Order order, @PathVariable Long customerid) {
        Order order1 = orderMapper.toEntity(order);
        Order savedOrder = orderService.addOrder(order,customerid);
        return ResponseEntity.ok(orderMapper.toDTO(savedOrder));
    }
}
