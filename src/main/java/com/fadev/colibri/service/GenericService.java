/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.service;

import com.fadev.colibri.exception.RestResourceNotFoundException;

import java.util.List;

/**
 * Service Interface that provides CRUD operations for {@link T} entries.
 *
 * @author Fabrizio Ariano.
 */
public interface GenericService<T> {

    /**
     * This method creates a new {@link T} object, saves the created object to the database,
     * and returns the information of the created {@link T} entry.
     * @param author the {@link T} object to be created.
     * @return the object created.
     */
    T create(T author);

    /**
     * This method finds the deleted {@link T} object, deletes it, and returns the information
     * about the deleted entry. If no object is found with the given id, this method throws the
     * {@link com.fadev.colibri.exception.RestResourceNotFoundException}.
     * @param id the {@link T} id
     * @return the {@link T} object deleted
     * @throws RestResourceNotFoundException if no object is found with the given id
     */
    T delete(String id) throws RestResourceNotFoundException;

    /**
     * This method finds the updated {@link T} object from the database, updates its fields,
     * saves it, and returns the updated information. If the updated object is not found,
     * this method throws the {@link com.fadev.colibri.exception.RestResourceNotFoundException}.
     * @param author the {@link T} object from which retrieve the new data
     * @return the {@link T} object updated
     * @throws RestResourceNotFoundException if no object is found
     */
    T update(T author) throws RestResourceNotFoundException;

    /**
     * This methods retrieves all {@link T} objects from the database, and returns the list.
     * @return the list pf {@link T} objects present into the database.
     */
    List<T> findAll();

    /**
     * This method finds the {@link T} object from the database and returns it.
     * If no entry is found, this method throws the {@link com.fadev.colibri.exception.RestResourceNotFoundException}.
     * @param id the {@link T} id
     * @return the {@link T} object found
     * @throws RestResourceNotFoundException if no object is found with the given id
     */
    T findById(String id) throws RestResourceNotFoundException;
}
