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
import com.fadev.colibri.repo.BookRepository;
import com.fadev.colibri.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DbSeeder implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public DbSeeder(AuthorRepository authorRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Book deaverBook1 = new Book("La consulente", "Thriller", "1992", "978-88-17-05603-8");
        Book deaverBook2 = new Book("Pietà per gli insonni", "Thriller", "1993", "978-84-95-65747-1");
        Book brownBook1 = new Book("Angeli e Demoni", "Thriller", "2000", "978-84-95-61877-1");
        Book brownBook2 = new Book("Il codice Da Vinci", "Thriller", "2003", "978-84-95-61877-2");

        this.bookRepository.deleteAll();
        this.bookRepository.save(Arrays.asList(deaverBook1, deaverBook2, brownBook1, brownBook2));

        Author jefferyDeaver = new Author("Jeffery", "Deaver",
                Arrays.asList(deaverBook1.getId(), deaverBook2.getId())
        );

        Author danBrown = new Author("Dan", "Brown",
                Arrays.asList(brownBook1.getId(), brownBook2.getId())
        );


        this.authorRepository.deleteAll();
        this.authorRepository.save(Arrays.asList(jefferyDeaver, danBrown));



        User fab = new User("Jonh", "Doe");
        User gian = new User("Guybrush", "Threepwood");
        this.userRepository.deleteAll();
        this.userRepository.save(Arrays.asList(fab, gian));
    }
}
