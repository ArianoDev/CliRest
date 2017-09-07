package com.fadev.colibri.repo;

import com.fadev.colibri.bean.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Author findByLastName(@Param("lastname") String lastname);
}
