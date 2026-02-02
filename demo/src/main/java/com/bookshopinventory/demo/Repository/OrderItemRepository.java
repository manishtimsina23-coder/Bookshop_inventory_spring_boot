package com.bookshopinventory.demo.Repository;

import com.bookshopinventory.demo.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
