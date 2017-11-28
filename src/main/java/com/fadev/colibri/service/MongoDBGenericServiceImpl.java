/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.service;

import com.fadev.colibri.bean.IData;
import com.fadev.colibri.util.RestPrecondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * {@link GenericService} implementation for Mongo Db.
 *
 * @author Fabrizio Ariano.
 */
public class MongoDBGenericServiceImpl<T extends IData<T>> implements GenericService<T> {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBGenericServiceImpl.class);
    protected final MongoRepository<T, String> repository;

    public MongoDBGenericServiceImpl(MongoRepository<T, String> repository) {
        this.repository = repository;
        logger.debug("MongoDBTServiceImpl successfully initialized");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T create(T data) {
        logger.info("Creating a new entry: {}", data);
        return repository.save(data);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T delete(String id) {
        logger.info("Deleting entry with id: {}", id);
        T toBeDeleted = RestPrecondition.checkNotNull(repository.findOne(id));
        repository.delete(toBeDeleted);
        logger.debug("Entry successfully deleted: ", toBeDeleted);
        return toBeDeleted;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T update(T data) {
        logger.info("Updating entry with id: {}", data.getId());
        T toBeUpdated = RestPrecondition.checkNotNull(repository.findOne(data.getId()));
        toBeUpdated.update(data);
        logger.debug("Entry successfully updated: {}", toBeUpdated);
        return repository.save(toBeUpdated);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll() {
        logger.info("Finding all entries.");
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T findById(String id) {
        logger.info("Finding entry with id: {}", id);
        return RestPrecondition.checkNotNull(repository.findOne(id));
    }
}
