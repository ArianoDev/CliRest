package com.fadev.colibri.controller;

import com.fadev.colibri.bean.Author;
import com.fadev.colibri.bean.Book;
import com.fadev.colibri.repo.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping("/books")
public class BookController {

    private AuthorRepository authorRepository;

    public BookController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

//    @GetMapping("/all")
//    public List<Book> getAll() {
//
//    }
}
