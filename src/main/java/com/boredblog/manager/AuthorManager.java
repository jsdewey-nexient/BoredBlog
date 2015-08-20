package com.boredblog.manager;

import com.boredblog.entity.Author;
import com.boredblog.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Handle Author objects.
 */
@Service
public class AuthorManager {
    @Autowired
    private AuthorRepository authorRepository;

    public Author create(Author author) {
        return this.authorRepository.save(author);
    }

    public Author retrieve(Integer id) {
        return this.authorRepository.findOne(id);
    }

    public List<Author> retrieveAll() {
        return this.authorRepository.findAll();
    }

    public Author update(Author author) {
        return this.create(author);
    }
}
