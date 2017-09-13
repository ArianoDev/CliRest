/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.util;

import com.fadev.colibri.exception.RestResourceNotFoundException;

/**
 * RestPrecondition provides a set of security checks.
 *
 * @author Fabrizio Ariano.
 */
public class RestPrecondition {

    /**
     * Ensures that the object given as a method parameter is not null.
     * @param resource the reference to the inspected object.
     * @param <T> the type of input object
     * @return the input resource if it is not a null reference
     * @throws java.lang.NullPointerException If the object given as a method parameter is null.
     */
    public static <T> T checkNotNull(T resource) throws RestResourceNotFoundException {
        if (resource == null) {
            throw new RestResourceNotFoundException();
        }
        return resource;
    }
}
