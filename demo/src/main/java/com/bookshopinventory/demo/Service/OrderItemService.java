package com.bookshopinventory.demo.Service;


import com.bookshopinventory.demo.Converter.OrderItemMapper;
import com.bookshopinventory.demo.Repository.BookRepository;
import com.bookshopinventory.demo.Repository.OrderItemRepository;
import com.bookshopinventory.demo.Repository.OrderRepository;
import com.bookshopinventory.demo.model.Book;
import com.bookshopinventory.demo.model.Order;
import com.bookshopinventory.demo.model.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderItemService {
    private final BookRepository bookRepository;
    private OrderItemRepository orderItemRepository;
    private OrderItemMapper orderItemMapper;
    private OrderRepository orderRepository;
    public OrderItemService(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper, OrderRepository orderRepository, BookRepository bookRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
    }

    public OrderItem addOrderItem(OrderItem orderItem, Long orderid, Long bookid) {
        Order order = orderRepository.findById(orderid).orElse(null);
        Book book = bookRepository.findById(bookid).orElse(null);
        orderItem.setOrder(order);
        orderItem.setBook(book);
        return orderItemRepository.save(orderItem);
    }
}
