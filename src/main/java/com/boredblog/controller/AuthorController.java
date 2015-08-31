package com.boredblog.controller;

import com.boredblog.entity.Author;
import com.boredblog.manager.AuthorManager;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<Author> getAuthors() {
        return this.authorManager.retrieveAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Author createAuthor(@RequestBody Author author) {
        return this.authorManager.create(author);
    }

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
