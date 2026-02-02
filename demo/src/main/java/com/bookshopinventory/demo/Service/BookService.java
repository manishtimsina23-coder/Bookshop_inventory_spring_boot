package com.bookshopinventory.demo.Service;

import com.bookshopinventory.demo.Converter.BookMapper;
import com.bookshopinventory.demo.DTO.BookDTO;
import com.bookshopinventory.demo.Repository.AuthorRepository;
import com.bookshopinventory.demo.Repository.BookRepository;
import com.bookshopinventory.demo.model.Author;
import com.bookshopinventory.demo.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookrepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookrepository, AuthorRepository authorRepository, BookMapper bookMapper) {
        this.bookrepository = bookrepository;
        this.authorRepository = authorRepository;
        this.bookMapper = bookMapper;
    }

    public List<Book> getAll(){
        return bookrepository.findAll();
    }

    public Book addBook(Book book,Long authorid){
        Author author = authorRepository.findById(authorid).orElse(null);
        book.setAuthor(author);
        return bookrepository.save(book);
    }

    public Book getBookById(Long id){
        return bookrepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id , Book bok){
        Book existing = bookrepository.findById(id).orElse(null);

        if(existing != null){
            existing.setTitle(bok.getTitle());
            existing.setAuthor(bok.getAuthor());
            existing.setPrice(bok.getPrice());
            existing.setPublish(bok.getPublish());
            existing.setInStock(bok.isInStock());
            return  bookrepository.save(existing);
        }
        return null;
    }

    public void deleteBook(Long id){
        bookrepository.deleteById(id);
    }

    public BookDTO saveBook(BookDTO bookDTO) {

        // fetch author from DB
        Author author = authorRepository.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        // map DTO → entity
        Book book = bookMapper.toEntity(bookDTO);

        // save in DB
        Book savedBook = bookrepository.save(book);

        // map back entity → DTO
        BookDTO savedDTO = bookMapper.toDTO(savedBook);

        return savedDTO;
    }
}
