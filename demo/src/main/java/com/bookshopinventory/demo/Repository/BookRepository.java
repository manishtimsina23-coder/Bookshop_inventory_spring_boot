package com.bookshopinventory.demo.Repository;

import com.bookshopinventory.demo.model.Book;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
