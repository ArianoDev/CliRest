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

import java.util.ArrayList;
import java.util.List;

/**
 * Class that contains the information of a single Author entry.
 *
 * @author Fabrizio Ariano
 */
@Document(collection = "Authors")
public class Author implements IData<Author>{

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private List<String> books;

    public Author() {
        this.books = new ArrayList<>();
    }

    public Author(String firstName, String lastName, List<String> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    /**
     * Allows to retrieve the value of id param.
     *
     * @return the value of id param
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Allows to retrieve the value of firstName param.
     *
     * @return the value of firstName parameter
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of firstName param.
     *
     * @param firstName the value to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Allows to retrieve the value of lastName param.
     *
     * @return the value of lastName parameter
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of lastName param.
     *
     * @param lastName the value to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Allows to retrieve the value of books param.
     *
     * @return the value of books parameter
     */
    public List<String> getBooks() {
        return books;
    }

    /**
     * Sets the value of books param.
     *
     * @param books the value to set
     */
    public void setBooks(List<String> books) {
        this.books = books;
    }

    /**
     * Updates self instance with input data
     * @param source the source object from which retrieve data
     */
    @Override
    public void update(Author source) {
        if(source == null) {
            throw new IllegalArgumentException("Source obj could not be null");
        }
        setFirstName(source.getFirstName());
        setLastName(source.getLastName());
        setBooks(source.getBooks());
    }
}
