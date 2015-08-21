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
    private final long CREATED_AT_TS = 1439218106000L; // Random long.
    private final long UPDATED_AT_TS = CREATED_AT_TS + 86400000; // Adds a day.
    private final Timestamp CREATED_AT = new Timestamp(CREATED_AT_TS);
    private final Timestamp UPDATED_AT = new Timestamp(UPDATED_AT_TS);
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
    public void testFirstName() {
        String result = this.author.getFirstName();

        assertEquals("testFirstName received a string different than the " +
                "one that was set.", FIRST_NAME, result);
    }

    @Test
    public void testLastName() {
        String result = this.author.getLastName();

        assertEquals("testLastName received a string different than the " +
                "one that was set.", LAST_NAME, result);
    }

    @Test
    public void testScreenName() {
        String result = this.author.getScreenName();

        assertEquals("testScreenName received a string different than the " +
                "one that was set.", SCREEN_NAME, result);
    }

    @Test
    public void testPassword() {
        String result = this.author.getPassword();
        
        assertEquals("testPassword received a string different that the " +
                "one that was set.", PASS, result);
    }
    
    @Test
    public void testPosts() {
        assertEquals(
                "testPosts received a mocked List that is different " +
                    "than the one that was injected.", 
                this.posts,
                this.author.getPosts());
    }
    
    @Test
    public void testComments() {
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
