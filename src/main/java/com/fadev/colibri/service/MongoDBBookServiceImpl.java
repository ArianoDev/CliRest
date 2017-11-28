/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.service;

import com.fadev.colibri.bean.Book;
import com.fadev.colibri.repo.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {@link GenericService} implementation about {@link Book} for Mongo Db.
 *
 * @author Fabrizio Ariano.
 */
@Service
public class MongoDBBookServiceImpl extends MongoDBGenericServiceImpl<Book> {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBBookServiceImpl.class);

    @Autowired
    public MongoDBBookServiceImpl(BookRepository repository) {
        super(repository);
        logger.debug("MongoDBBookServiceImpl successfully initialized");
    }

}
