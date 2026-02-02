package com.bookshopinventory.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotBlank(message = "title shouldn't be blank")
    private String title;

//    @Column(name = "author")
//    @NotBlank(message = "Author shouldn't be blank")
//    private String author;

    @Column(name = "price")
    private int price;

    @Column(name = "inStock")
    private boolean inStock;

    @Column(name = "publish")
    private Date publish;

    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Order> orders;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public Date getPublish() {
        return publish;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }

    public Long getId() {
        return id;
    }

//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
