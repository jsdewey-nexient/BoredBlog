package com.boredblog.controller;

import com.boredblog.entity.Author;
import com.boredblog.jsonview.AuthorJsonView;
import com.boredblog.manager.AuthorManager;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private AuthorManager authorManager;

    @Autowired
    public AuthorController(AuthorManager authorManager) {
        this.authorManager = authorManager;
    }

    @JsonView(AuthorJsonView.ListAuthors.class)
    @RequestMapping(method = RequestMethod.GET)
    public List<Author> getAuthors() {
        return this.authorManager.retrieveAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Author createAuthor(@RequestBody Author author) {
        return this.authorManager.create(author);
    }

    @JsonView(AuthorJsonView.ShowAuthorDetail.class)
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Author getAuthor(@PathVariable Integer id) {
        return this.authorManager.retrieve(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Author updateAuthor(
            @PathVariable Integer id,
            @RequestBody Author author
    ) {
        return this.authorManager.update(id, author);
    }
}
