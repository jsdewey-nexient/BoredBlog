package com.boredblog.manager;

import com.boredblog.entity.Author;
import com.boredblog.repository.AuthorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that the AuthorManager works as intended.
 */
public class AuthorManagerTest {
    private final Integer AUTHOR_ID = 1;
    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private AuthorManager authorManager;
    private Author author;
    private Author updatedAuthor;
    private List<Author> authors;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        createDependentObjects();
        this.mockAuthorRepository();
    }

    @Test
    public void testCreateAuthor() {

    }

    private void createDependentObjects() {
        this.author = new Author();
        this.updatedAuthor = new Author();
        this.authors = new ArrayList<>();
        this.authors.add(this.author);
        this.authors.add(this.updatedAuthor);
    }

    private void mockAuthorRepository() {
        Mockito.when(this.authorRepository.findOne(AUTHOR_ID))
                .thenReturn(this.author);
        Mockito.when(this.authorRepository.findAll())
                .thenReturn(this.authors);
        Mockito.when(this.authorRepository.save(this.author))
                .thenReturn(this.author);
        Mockito.when(this.authorRepository.save(this.updatedAuthor))
                .thenReturn(this.updatedAuthor);
    }
}
