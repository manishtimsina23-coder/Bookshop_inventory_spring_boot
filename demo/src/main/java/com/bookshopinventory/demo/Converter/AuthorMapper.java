package com.bookshopinventory.demo.Converter;

import com.bookshopinventory.demo.DTO.AuthorDTO;
import com.bookshopinventory.demo.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public AuthorDTO toDTO(Author author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setEmail(author.getEmail());
        dto.setCountry(author.getCountry());
        return dto;
    }

    public Author toEntity(AuthorDTO dto) {
        Author author = new Author();
        author.setId(dto.getId());
        author.setName(dto.getName());
        author.setEmail(dto.getEmail());
        author.setCountry(dto.getCountry());
        return author;
    }
}
