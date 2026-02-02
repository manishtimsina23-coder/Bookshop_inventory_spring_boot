package com.bookshopinventory.demo.Controller;


import com.bookshopinventory.demo.Converter.AuthorMapper;
import com.bookshopinventory.demo.DTO.AuthorDTO;
import com.bookshopinventory.demo.Service.AuthorService;
import com.bookshopinventory.demo.model.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAll();
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorDTO){
        Author author = authorMapper.toEntity(authorDTO);
        Author savedAuthor = authorService.addAuthor(author);
        return ResponseEntity.ok(authorMapper.toDTO(savedAuthor));
    }
}
