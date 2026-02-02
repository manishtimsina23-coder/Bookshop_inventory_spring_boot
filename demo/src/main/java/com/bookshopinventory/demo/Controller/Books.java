package com.bookshopinventory.demo.Controller;

import com.bookshopinventory.demo.Converter.BookMapper;
import com.bookshopinventory.demo.DTO.BookDTO;
import com.bookshopinventory.demo.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookshopinventory.demo.model.Book;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class Books {
    private final BookService bookservice;
    private final BookMapper bookmapper;

    public Books(BookService bookservice, BookMapper bookmapper) {
        this.bookservice = bookservice;
        this.bookmapper = bookmapper;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookservice.getAll();
    }

//    @PostMapping
//    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookdto) {
//        Book book = bookmapper.toEntity(bookdto);
//        Book savedbook = bookservice.addBook(book);
//        return ResponseEntity.ok(bookmapper.toDTO(savedbook));
//    }

    @PostMapping("{authorid}")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookdto, @PathVariable Long authorid) {
        Book book = bookmapper.toEntity(bookdto);
        Book savedbook = bookservice.addBook(book,authorid);
        return ResponseEntity.ok(bookmapper.toDTO(savedbook));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable Long id){
        Book searchBook = bookservice.getBookById(id);
        return ResponseEntity.ok(bookmapper.toDTO(searchBook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book bok = new Book();
        bok.setTitle(book.getTitle());
        bok.setAuthor(book.getAuthor());
        bok.setPrice(book.getPrice());
        bok.setInStock(book.isInStock());
        bok.setPublish(book.getPublish());
        Book updated = bookservice.updateBook(id, bok);
        return new ResponseEntity<>(updated,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookservice.deleteBook(id);
    }
}
