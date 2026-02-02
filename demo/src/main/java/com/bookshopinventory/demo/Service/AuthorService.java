package com.bookshopinventory.demo.Service;

import com.bookshopinventory.demo.Repository.AuthorRepository;
import com.bookshopinventory.demo.model.Author;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }
}
