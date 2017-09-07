package com.fadev.colibri.controller;

import com.fadev.colibri.bean.Author;
import com.fadev.colibri.repo.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/all")
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @GetMapping("/author")
    public Author getAuthor(@RequestParam(value="name") String name) {
        return authorRepository.findByLastName(name);
    }
}
