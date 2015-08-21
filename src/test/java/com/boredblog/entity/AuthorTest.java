package com.boredblog.entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that the Author entity works as expected.
 */
public class AuthorTest {
    private final String FIRST_NAME = "Johnny";
    private final String LAST_NAME = "Nexient";
    private final String SCREEN_NAME = "jNexient2";
    private final String PASS = "$2a$12$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyG" +
            "PBr08PpIi0na624b8.";
    @Mock
    private List<Post> posts;
    @Mock
    private List<Comment> comments;
    @InjectMocks
    private Author author;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.setUnmockedFields();
    }

    @Test
    public void testFirstNameMatches() {
        String result = this.author.getFirstName();

        assertEquals("testFirstName received a string different than the " +
                "one that was set.", FIRST_NAME, result);
    }

    @Test
    public void testLastNameMatches() {
        String result = this.author.getLastName();

        assertEquals("testLastName received a string different than the " +
                "one that was set.", LAST_NAME, result);
    }

    @Test
    public void testScreenNameMatches() {
        String result = this.author.getScreenName();

        assertEquals("testScreenName received a string different than the " +
                "one that was set.", SCREEN_NAME, result);
    }

    @Test
    public void testPasswordMatches() {
        String result = this.author.getPassword();
        
        assertEquals("testPassword received a string different that the " +
                "one that was set.", PASS, result);
    }
    
    @Test
    public void testPostsMatches() {
        assertEquals(
                "testPosts received a mocked List that is different " +
                    "than the one that was injected.", 
                this.posts,
                this.author.getPosts());
    }
    
    @Test
    public void testCommentsMatches() {
        assertEquals(
                "testComments received a mocked List that is different " +
                    "than the one that was injected.", 
                this.comments, 
                this.author.getComments());
    }

    private void setUnmockedFields() {
        this.author.setFirstName(FIRST_NAME);
        this.author.setLastName(LAST_NAME);
        this.author.setScreenName(SCREEN_NAME);
        this.author.setPassword(PASS);
    }
}
