package com.fernando.biblioteca_rocket.model.book;

import lombok.Data;

// Lombok annotation to generate getters, setters, toString, equals, hashCode.
@Data
public class Book {

    //attributes
    private Long idBook;
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private int stock;


    //constructor
    public Book(Long idBook, String title, String author, String genre, String isbn, int stock) {
        this.idBook = idBook;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.stock = stock;
    }

    public Book (){}


}
