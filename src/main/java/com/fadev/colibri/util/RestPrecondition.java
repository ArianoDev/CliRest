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

    public static <T> T checkNotNull(T resource) {
        if (resource == null) {
            throw new RestResourceNotFoundException();
        }
        return resource;
    }
}
