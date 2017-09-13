/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 */
package com.fadev.colibri;

import com.fadev.colibri.bean.Author;
import com.fadev.colibri.bean.Book;
import com.fadev.colibri.bean.User;
import com.fadev.colibri.repo.AuthorRepository;
import com.fadev.colibri.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DbSeeder implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private UserRepository userRepository;

    public DbSeeder(AuthorRepository authorRepository, UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Author jefferyDeaver = new Author("Jeffery", "Deaver",
                Arrays.asList(
                        new Book("La consulente", "Thriller", "1992", "978-88-17-05603-8"),
                        new Book("Pietà per gli insonni", "Thriller", "1993", "978-84-95-65747-1"))
        );

        Author danBrown = new Author("Dan", "Brown",
                Arrays.asList(
                        new Book("Angeli e Demoni", "Thriller", "2000", "978-84-95-61877-1"),
                        new Book("Il codice Da Vinci", "Thriller", "2003", "978-84-95-61877-2"))
        );


        this.authorRepository.deleteAll();
        this.authorRepository.save(Arrays.asList(jefferyDeaver, danBrown));

        User fab = new User("Fabrizio", "Ariano");
        User gian = new User("Gianluca", "Carroccia");
        this.userRepository.deleteAll();
        this.userRepository.save(Arrays.asList(fab, gian));
    }
}
