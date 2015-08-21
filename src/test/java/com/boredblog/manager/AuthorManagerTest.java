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

import static org.junit.Assert.*;


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
        Author result = this.authorManager.create(this.author);

        assertEquals(
                "testCreateAuthor did not receive the same Author object back.",
                this.author,
                result
        );
    }

    @Test
    public void testRetrievingSingleAuthor() {
        Author result = this.authorManager.retrieve(AUTHOR_ID);

        assertEquals(
                "testRetrievingAuthor did not receive expected Author object.",
                this.author,
                result
        );
    }

    @Test
    public void testRetrievingAllAuthors() {
        List<Author> result = this.authorManager.retrieveAll();

        assertEquals(
                "testRetrievingAllAuthors did not receive the expected " +
                        "List of Author objects.",
                this.authors,
                result
        );
    }

    @Test
    public void testUpdatingAuthor() {
        Author result = this.authorManager.update(AUTHOR_ID, this.author);

        assertEquals(
                "testUpdatingAuthor did not receive the updated Author object.",
                this.updatedAuthor,
                result
        );
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
