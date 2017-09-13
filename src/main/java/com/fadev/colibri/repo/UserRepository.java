/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.repo;

import com.fadev.colibri.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User Repository Interface used to save {@link User} objects to MondoDB
 * and retrieve {@link User} objects from it.
 *
 * @author Fabrizio Ariano.
 */
public interface UserRepository extends MongoRepository<User, String> {
}
