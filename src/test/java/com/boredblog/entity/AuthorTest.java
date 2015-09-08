package com.boredblog.entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that the Author entity works as expected.
 */
public class AuthorTest {
    public static final int ID = 1;
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

        this.author = this.setUnmockedProperties(this.author);
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

    @Test
    public void testFullNameMatches() {
        assertEquals(
                "testFullNameMatches did not return the expected full name.",
                FIRST_NAME + " " + LAST_NAME,
                this.author.getFullName()
        );
    }

    @Test
    public void testEquals() {
        Author otherAuthor = new Author();
        otherAuthor = this.setUnmockedProperties(otherAuthor);
        otherAuthor.setPosts(this.posts);
        otherAuthor.setComments(this.comments);
        assertTrue(
                "The two Author objects in testEquals are not equal.",
                this.author.equals(otherAuthor) && otherAuthor.equals(this.author)
        );
    }

    @Test
    public void testHashCode() {
        Author otherAuthor = new Author();
        otherAuthor = this.setUnmockedProperties(otherAuthor);
        otherAuthor.setPosts(this.posts);
        otherAuthor.setComments(this.comments);
        assertTrue(
                "The hash codes of the two Author objects in testHashCode " +
                        "are not the same.",
                this.author.hashCode() == otherAuthor.hashCode()
        );
    }

    private Author setUnmockedProperties(Author author) {
        author.setFirstName(FIRST_NAME);
        author.setLastName(LAST_NAME);
        author.setScreenName(SCREEN_NAME);
        author.setPassword(PASS);
        author.setId(ID);

        return author;
    }
}
