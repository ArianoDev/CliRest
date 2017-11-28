/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.controller;

import com.fadev.colibri.bean.Author;
import com.fadev.colibri.exception.RestResourceNotFoundException;
import com.fadev.colibri.service.GenericService;
import com.fadev.colibri.util.RestPrecondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * This controller provides the public API that is used to manage the information about {@link Author} entries.
 *
 * @author Fabrizio Ariano
 */
@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    private final GenericService<Author> service;

    @Autowired
    public AuthorController(GenericService<Author> service) {
        this.service = service;
    }

    /**
     * Read the information of the created {@link Author} entry from the request body,
     * validate the information of the created entry and create a new entry and return it.
     * Finally set the response status to 201.
     * @param author the object to be created
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Author create(@RequestBody @Valid Author author) {
        RestPrecondition.checkNotNull(author);
        return service.create(author);
    }

    /**
     * Delegates the id of the deleted entry forward to our service and return the deleted {@link Author} object.
     * @param id the Author ID to be deleted
     * @return the {@link Author} entry deleted.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    Author delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    /**
     * Finds the {@link Author} entries from the database and returning the found entries.
     * @return a List of {@link Author} objects.
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Author> findAll() {
        return service.findAll();
    }

    /**
     * Finds the {@link Author} entry from the database and returning the found entry.
     * @param id the Author ID to be found.
     * @return the {@link Author} object found.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Author findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    /**
     * Read the information of the updated {@link Author} entry from the request body,
     * validates the information of the updated entry and update the information of the entry.
     * Finally returns the updated {@link Author} entry.
     * @param author the {@link Author} from which retrieve data
     * @return the {@link Author} entry updated
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Author update(@RequestBody @Valid Author author) {
        return service.update(author);
    }

    /**
     * This method sets the response status to 404 if the {@link Author} entry was not found
     * ({@link RestResourceNotFoundException} was thrown).
     * @param ex the {@link RestResourceNotFoundException} to be handled
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleResourceNotFound(RestResourceNotFoundException ex) {
        logger.error("Handling error with message: {}", ex.getMessage());
    }

}
