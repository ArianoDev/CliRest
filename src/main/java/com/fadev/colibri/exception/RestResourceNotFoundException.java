/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.exception;

/**
 * This exception is thrown when a requested entry is not found.
 * @author Fabrizio Ariano
 */
public class RestResourceNotFoundException extends NullPointerException {

    public RestResourceNotFoundException(String s) {
        super(String.format("Resource (<%s>) is null, so could not be processed", s));
    }
}
