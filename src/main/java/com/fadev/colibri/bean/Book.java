package com.fadev.colibri.bean;

import org.springframework.data.annotation.Id;

public class Book {

    @Id
    private String id;
    private String name;
    private String genre;
    private String date;
    private String isbn;

    public Book(String name, String genre, String date, String isbn) {
        this.name = name;
        this.genre = genre;
        this.date = date;
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
