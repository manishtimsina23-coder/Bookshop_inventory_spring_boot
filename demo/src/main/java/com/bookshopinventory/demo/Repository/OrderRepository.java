package com.bookshopinventory.demo.Repository;
import com.bookshopinventory.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
