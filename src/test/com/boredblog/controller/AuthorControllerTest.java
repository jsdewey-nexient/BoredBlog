package com.boredblog.controller;

import com.boredblog.entity.Author;
import com.boredblog.manager.AuthorManager;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

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
    @InjectMocks
    private AuthorController authorController;

    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(this.authorManager.retrieveAll()).thenReturn(this.authors);
    }

    public void testRetrievingAllAuthors() {
        List<Author> result = this.authorController.getAuthors();

        Assert.assertEquals("testRetrievingAllAuthors did not receive the " +
                "mocked List of Author objects back.", this.authors, result);
        Mockito.verify(this.authorManager).retrieveAll();
    }
}
