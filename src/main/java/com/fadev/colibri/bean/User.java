/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that contains the information of a single User entry.
 *
 * @author Fabrizio Ariano
 */
@Document(collection = "User")
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Allows to retrieve the value of firstName param.
     *
     * @return the value of firstName parameter
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of firstName param.
     *
     * @param firstName the value to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Allows to retrieve the value of lastName param.
     *
     * @return the value of lastName parameter
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of lastName param.
     *
     * @param lastName the value to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
