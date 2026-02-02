package com.bookshopinventory.demo.Converter;

import com.bookshopinventory.demo.DTO.BookDTO;
import com.bookshopinventory.demo.model.Author;
import com.bookshopinventory.demo.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookDTO toDTO(Book book) {
        BookDTO bookdto = new BookDTO();
        bookdto.setId(book.getId());
       // bookdto.setAuthor(book.getAuthor());
        bookdto.setTitle(book.getTitle());
        bookdto.setPrice(book.getPrice());
        bookdto.setInStock(book.isInStock());
        bookdto.setPublish(book.getPublish());

        if(book.getAuthor() != null){
            bookdto.setAuthorId(book.getAuthor().getId());
            bookdto.setAuthorName(book.getAuthor().getName());
        }
        return bookdto;
    }

    public Book toEntity(BookDTO bookdto) {
        Book book = new Book();
        book.setId(bookdto.getId());
        //book.setAuthor(bookdto.getAuthor());
        book.setTitle(bookdto.getTitle());
        book.setPrice(bookdto.getPrice());
        book.setInStock(bookdto.isInStock());
        book.setPublish(bookdto.getPublish());
        //book.setAuthor(author);
        return book;
    }
}
