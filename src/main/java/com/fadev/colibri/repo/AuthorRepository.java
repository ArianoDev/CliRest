/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.repo;

import com.fadev.colibri.bean.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Author Repository Interface used to save {@link Author} objects to MondoDB
 * and retrieve {@link Author} objects from it.
 *
 * @author Fabrizio Ariano.
 */
public interface AuthorRepository extends MongoRepository<Author, String> {

    /**
     * Finds the {@link Author} entry with has input Last Name or input First Name.
     * @param lastname last name value of {@link Author} to be found
     * @param firstname first name value of {@link Author} to be found
     * @return the list of all {@link Author} entries which have last name or first name, equal to input values.
     */
    List<Author> findByLastNameOrFirstNameAllIgnoreCase(String lastname, String firstname);

}
