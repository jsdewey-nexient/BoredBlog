package com.boredblog.controller;

import com.boredblog.entity.Author;
import com.boredblog.manager.AuthorManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Test the functionality of the AuthorController.
 */
public class AuthorControllerTest {
    @Mock
    private List<Author> authors;
    @Mock
    private AuthorManager authorManager;
    @Mock
    private Author author;
    @InjectMocks
    private AuthorController authorController;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockAuthorManager();
    }

    @Test
    public void testRetrievingAllAuthors() {
        List<Author> result = this.authorController.getAuthors();

        assertEquals("testRetrievingAllAuthors did not receive the " +
                "mocked List of Author objects back.", this.authors, result);
        Mockito.verify(this.authorManager).retrieveAll();
    }

    @Test
    public void testRetrievingOneAuthor() {
        Author result = this.authorController.getAuthor(1);

        assertEquals("testRetrievingOneAuthor did not receive the " +
                "mocked Author object back.", this.author, result);
        Mockito.verify(this.authorManager).retrieve(1);
    }

    @Test
    public void testCreatingAuthor() {
        Author result = this.authorController.createAuthor(this.author);

        assertEquals("testCreatingAuthor did not receive the mocked " +
                "Author object back.", this.author, result);
        Mockito.verify(this.authorManager).create(this.author);
    }

    private void mockAuthorManager() {
        Mockito.when(this.authorManager.retrieveAll())
                .thenReturn(this.authors);
        Mockito.when(this.authorManager.retrieve(1))
                .thenReturn(this.author);
        Mockito.when(this.authorManager.create(this.author))
                .thenReturn(this.author);
    }
}