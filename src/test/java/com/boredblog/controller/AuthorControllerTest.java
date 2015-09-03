package com.boredblog.controller;

import com.boredblog.controller.AuthorController;
import com.boredblog.entity.Author;
import com.boredblog.manager.AuthorManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Test the functionality of the AuthorController.
 */
public class AuthorControllerTest {
    private final Integer AUTHOR_ID = 1;
    @Mock
    private List<Author> authors;
    @Mock
    private AuthorManager authorManager;
    @Mock
    private Author author;
    @Mock
    private Author updateAuthor;
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
    public void testRetrievingSingleAuthor() {
        Author result = this.authorController.getAuthor(AUTHOR_ID);

        assertEquals("testRetrievingOneAuthor did not receive the " +
                "mocked Author object back.", this.author, result);
        Mockito.verify(this.authorManager).retrieve(AUTHOR_ID);
    }

    @Test
    public void testCreatingAuthor() {
        Author result = this.authorController.createAuthor(this.author);

        assertEquals("testCreatingAuthor did not receive the mocked " +
                "Author object back.", this.author, result);
        Mockito.verify(this.authorManager).create(this.author);
    }

    @Test
    public void testUpdatingAuthor() {
        Author result = this.authorController.updateAuthor(AUTHOR_ID, this.author);

        assertEquals("testUpdatingAuthor did not receive the other mocked " +
                "Author object back.", this.updateAuthor, result);
        Mockito.verify(this.authorManager).update(AUTHOR_ID, this.author);
    }

    private void mockAuthorManager() {
        Mockito.when(this.authorManager.retrieveAll())
                .thenReturn(this.authors);
        Mockito.when(this.authorManager.retrieve(AUTHOR_ID))
                .thenReturn(this.author);
        Mockito.when(this.authorManager.create(this.author))
                .thenReturn(this.author);
        Mockito.when(this.authorManager.update(AUTHOR_ID, this.author))
                .thenReturn(this.updateAuthor);
    }
}
