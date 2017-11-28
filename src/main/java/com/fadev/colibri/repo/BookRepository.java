package com.fadev.colibri.repo;

import com.fadev.colibri.bean.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User Repository Interface used to save {@link Book} objects to MondoDB
 * and retrieve {@link Book} objects from it.
 *
 * @author Fabrizio Ariano.
 */
public interface BookRepository extends MongoRepository<Book, String> {
}
