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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {@link GenericService} implementation about {@link Author} for Mongo Db.
 *
 * @author Fabrizio Ariano.
 */
@Service
public class MongoDBAuthorServiceImpl extends MongoDBGenericServiceImpl<Author> {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBAuthorServiceImpl.class);

    @Autowired
    public MongoDBAuthorServiceImpl(AuthorRepository repository) {
        super(repository);
        logger.debug("MongoDBAuthorServiceImpl successfully initialized");
    }

}
