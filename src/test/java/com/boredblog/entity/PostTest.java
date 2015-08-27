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
 * Verify that the Post entity works as intended.
 */
public class PostTest extends BaseTimestampTest {
    private final String TITLE = "Fake Title";
    private final String CONTENT = "Bacon ipsum dolor amet meatloaf ground " +
            "round fatback, salami jowl tenderloin short ribs shoulder " +
            "prosciutto sausage chicken capicola.";
    @Mock
    private Author author;
    @Mock
    private List<Comment> comments;
    @InjectMocks
    private Post post;

    @Before
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
        setUnmockedProperties();
    }

    @Test
    public void testTitleMatches() {
        String result = this.post.getTitle();

        assertEquals(
                "testTitleMatches did not receive expected title back.",
                TITLE,
                result
        );
    }

    @Test
    public void testContentMatches() {
        String result = this.post.getContent();

        assertEquals(
                "testContentMatches did not receive expected content back.",
                CONTENT,
                result
        );
    }

    @Test
    public void testCreatedAtMatches() {
        Timestamp result = this.post.getCreatedAt();

        assertEquals(
                "testCreatedAtMatches did not receive the expected Timestamp.",
                CREATED_AT,
                result
        );
    }

    @Test
    public void testUpdatedAtMatches() {
        Timestamp result = this.post.getUpdatedAt();

        assertEquals(
                "testUpdatedAtMatches did not receive the expected Timestamp.",
                UPDATED_AT,
                result
        );
    }

    @Test
    public void testCommentsMatches() {
        List<Comment> result = this.post.getComments();

        assertEquals(
                "testCommentsMatches did not receive the expected List " +
                        "of Comments.",
                this.comments,
                result
        );
    }

    @Test
    public void testAuthorMatches() {
        User result = this.post.getAuthor();

        assertEquals(
                "testAuthorMatches did not receive the expected mocked Author.",
                this.author,
                result
        );
    }

    private void setUnmockedProperties() {
        this.post.setTitle(TITLE);
        this.post.setContent(CONTENT);
        this.post.setCreatedAt(CREATED_AT);
        this.post.setUpdatedAt(UPDATED_AT);
    }
}
