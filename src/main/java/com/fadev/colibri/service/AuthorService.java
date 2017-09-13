/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.service;

import com.fadev.colibri.bean.Author;
import com.fadev.colibri.exception.RestResourceNotFoundException;

import java.util.List;

/**
 * Service Interface that provides CRUD operations for {@link Author} entries.
 *
 * @author Fabrizio Ariano.
 */
public interface AuthorService {

    /**
     * This method creates a new {@link Author} object, saves the created object to the database,
     * and returns the information of the created {@link Author} entry.
     * @param author the {@link Author} object to be created.
     * @return the object created.
     */
    Author create(Author author);

    /**
     * This method finds the deleted {@link Author} object, deletes it, and returns the information
     * about the deleted entry. If no object is found with the given id, this method throws the
     * {@link com.fadev.colibri.exception.RestResourceNotFoundException}.
     * @param id the {@link Author} id
     * @return the {@link Author} object deleted
     * @throws RestResourceNotFoundException if no object is found with the given id
     */
    Author delete(String id) throws RestResourceNotFoundException;

    /**
     * This method finds the updated {@link Author} object from the database, updates its fields,
     * saves it, and returns the updated information. If the updated object is not found,
     * this method throws the {@link com.fadev.colibri.exception.RestResourceNotFoundException}.
     * @param author the {@link Author} object from which retrieve the new data
     * @return the {@link Author} object updated
     * @throws RestResourceNotFoundException if no object is found
     */
    Author update(Author author) throws RestResourceNotFoundException;

    /**
     * This methods retrieves all {@link Author} objects from the database, and returns the list.
     * @return the list pf {@link Author} objects present into the database.
     */
    List<Author> findAll();

    /**
     * This method finds the {@link Author} object from the database and returns it.
     * If no entry is found, this method throws the {@link com.fadev.colibri.exception.RestResourceNotFoundException}.
     * @param id the {@link Author} id
     * @return the {@link Author} object found
     * @throws RestResourceNotFoundException if no object is found with the given id
     */
    Author findById(String id) throws RestResourceNotFoundException;
}
