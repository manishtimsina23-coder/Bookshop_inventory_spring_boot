package com.bookshopinventory.demo.Repository;

import com.bookshopinventory.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
