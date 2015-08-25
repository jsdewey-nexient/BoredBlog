package com.boredblog.entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that a Comment entity works as it should.
 */
public class CommentTest extends BaseTimestampTest {
    private final String CONTENT = "Lorem ipsum dolor sit amet, consectetur " +
            "adipiscing elit. Donec in.";
    @Mock
    private Author author;
    @Mock
    private Guest guest;
    private Comment comment;

    @Before
    public void setup() throws Exception {
        this.comment = new Comment();

        MockitoAnnotations.initMocks(this);
        this.setUnmockedProperties();
    }

    @Test
    public void testContentMatches() {
        String result = this.comment.getContent();

        assertEquals(
                "testContentMatches did not get the expected content " +
                        "back.",
                CONTENT,
                result
        );
    }

    @Test
    public void testUserAsAuthorMatches() {
        // User is set manually because we want to test the Author object.
        this.comment.setUser(this.author);
        User result = this.comment.getUser();

        assertEquals(
                "testUserAsAuthorMatches did not receive the mocked " +
                        "Author back.",
                this.author,
                result
        );
    }

    @Test
    public void testUserAsGuestMatches() {
        // User is set manually because we want to test the Guest object.
        this.comment.setUser(this.guest);
        User result = this.comment.getUser();

        assertEquals(
                "testUserAsGuestMatches did not receive the mocked " +
                        "Guest back.",
                this.guest,
                result
        );
    }

    @Test
    public void testCreatedAtMatches() {
        Timestamp result = this.comment.getCreatedAt();

        assertEquals(
                "testCreatedAtMatches did not receive the correct " +
                        "Timestamp back.",
                CREATED_AT,
                result
        );
    }

    @Test
    public void testUpdatedAtMatches() {
        Timestamp result = this.comment.getUpdatedAt();

        assertEquals(
                "testUpdatedAtMatches did not receive the correct " +
                        "Timestamp back.",
                UPDATED_AT,
                result
        );
    }

    private void setUnmockedProperties() {
        this.comment.setContent(CONTENT);
        this.comment.setCreatedAt(CREATED_AT);
        this.comment.setUpdatedAt(UPDATED_AT);
    }
}
