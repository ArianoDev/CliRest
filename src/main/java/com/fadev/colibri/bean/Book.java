/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that contains the information of a single Book entry.
 *
 * @author Fabrizio Ariano
 */
@Document(collection = "Books")
public class Book implements IData<Book>{

    @Id
    private String id;
    private String name;
    private String genre;
    private String date;
    private String isbn;

    public Book() {
        this("", "", "", "");
    }

    public Book(String name, String genre, String date, String isbn) {
        this.name = name;
        this.genre = genre;
        this.date = date;
        this.isbn = isbn;
    }

    /**
     *
     * @return
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Allows to retrieve the value of name param.
     *
     * @return the value of name parameter
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of name param.
     *
     * @param name the value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Allows to retrieve the value of genre param.
     *
     * @return the value of genre parameter
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of genre param.
     *
     * @param genre the value to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Allows to retrieve the value of date param.
     *
     * @return the value of date parameter
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of date param.
     *
     * @param date the value to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Allows to retrieve the value of isbn param.
     *
     * @return the value of isbn parameter
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the value of isbn param.
     *
     * @param isbn the value to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Updates self instance with input data
     * @param source the source object from which retrieve data
     */
    @Override
    public void update(Book source) {
        if(source == null) {
            throw new IllegalArgumentException("Source obj could not be null");
        }
        setDate(source.getDate());
        setGenre(source.getGenre());
        setIsbn(source.getIsbn());
        setName(source.getName());
    }
}
