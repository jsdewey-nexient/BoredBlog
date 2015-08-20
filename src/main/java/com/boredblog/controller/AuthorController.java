package com.boredblog.controller;

import com.boredblog.entity.Author;
import com.boredblog.manager.AuthorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/18/2015
 * Group: Joel
 * Responsible for delivering Author objects.
 */
@RestController
@RequestMapping("authors")
public class AuthorController {
    @Autowired
    private AuthorManager authorManager;

    public List<Author> getAuthors() {
        return this.authorManager.retrieveAll();
    }

    @RequestMapping("{id}")
    public Author getAuthor(@PathVariable Integer id) {
        return this.authorManager.retrieve(id);
    }
}
