package com.fadev.colibri.controller;

import com.fadev.colibri.bean.Book;
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
 * This controller provides the public API that is used to manage the information about {@link Book} entries.
 *
 * @author  Fabrizio Ariano
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final GenericService<Book> service;

    @Autowired
    public BookController(GenericService<Book> service) {
        this.service = service;
    }

    /**
     * Read the information of the created {@link Book} entry from the request body,
     * validate the information of the created entry and create a new entry and return it.
     * Finally set the response status to 201.
     *
     * @param book the object to be created
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Book create(@RequestBody @Valid Book book) {
        RestPrecondition.checkNotNull(book);
        return service.create(book);
    }

    /**
     * Delegates the id of the deleted entry forward to our service and return the deleted {@link Book} object.
     *
     * @param id the Book ID to be deleted
     * @return the {@link Book} entry deleted.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    Book delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    /**
     * Finds the {@link Book} entries from the database and returning the found entries.
     *
     * @return a List of {@link Book} objects.
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Book> findAll() {
        return service.findAll();
    }

    /**
     * Finds the {@link Book} entry from the database and returning the found entry.
     *
     * @param id the Book ID to be found.
     * @return the {@link Book} object found.
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Book findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    /**
     * Read the information of the updated {@link Book} entry from the request body,
     * validates the information of the updated entry and update the information of the entry.
     * Finally returns the updated {@link Book} entry.
     *
     * @param Book the {@link Book} from which retrieve data
     * @return the {@link Book} entry updated
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Book update(@RequestBody @Valid Book Book) {
        return service.update(Book);
    }

    /**
     * This method sets the response status to 404 if the {@link Book} entry was not found
     * ({@link RestResourceNotFoundException} was thrown).
     *
     * @param ex the {@link RestResourceNotFoundException} to be handled
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleResourceNotFound(RestResourceNotFoundException ex) {
        logger.error("Handling error with message: {}", ex.getMessage());
    }

}
