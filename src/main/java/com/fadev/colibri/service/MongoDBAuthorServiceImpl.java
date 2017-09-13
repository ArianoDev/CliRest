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
import com.fadev.colibri.repo.AuthorRepository;
import com.fadev.colibri.util.RestPrecondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@link AuthorService} implementation for Mongo Db.
 *
 * @author Fabrizio Ariano.
 */
@Service
public class MongoDBAuthorServiceImpl implements AuthorService {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBAuthorServiceImpl.class);
    private final AuthorRepository authorRepo;

    @Autowired
    public MongoDBAuthorServiceImpl(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
        logger.debug("MongoDBAuthorServiceImpl successfully initialized");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author create(Author author) {
        logger.info("Creating a new Author entry: {}", author);
        return authorRepo.save(author);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author delete(String id) {
        logger.info("Deleting Author entry with id: {}", id);
        Author toBeDeleted = RestPrecondition.checkNotNull(authorRepo.findOne(id));
        authorRepo.delete(toBeDeleted);
        logger.debug("Author entry successfully deleted: ", toBeDeleted);
        return toBeDeleted;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author update(Author author) {
        logger.info("Updating Author entry with id: {}", author.getId());
        Author toBeUpdated = RestPrecondition.checkNotNull(authorRepo.findOne(author.getId()));
        toBeUpdated.update(author);
        logger.debug("Author entry successfully updated: {}", toBeUpdated);
        return authorRepo.save(toBeUpdated);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Author> findAll() {
        logger.info("Finding all Authoe entries.");
        return authorRepo.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author findById(String id) {
        logger.info("Finding Author entry with id: {}", id);
        return RestPrecondition.checkNotNull(authorRepo.findOne(id));
    }
}
