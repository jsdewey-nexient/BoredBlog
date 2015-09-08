package com.boredblog.entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    private List<Comment> comments;
    @InjectMocks
    private Post post;

    @Before
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
        this.post = setUnmockedProperties(this.post);
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
    public void testEquals() {
        Post otherPost = new Post();
        this.setUnmockedProperties(otherPost);
        assertTrue(
                "The two Post objects in testEquals are not equal.",
                this.post.equals(otherPost) && otherPost.equals(this.post)
        );
    }

    @Test
    public void testHashCode() {
        Post otherPost = new Post();
        otherPost = this.setUnmockedProperties(otherPost);
        otherPost.setComments(this.comments);
        assertTrue(
                "The hash codes of the two Post objects in testHashCode " +
                        "are not the same.",
                this.post.hashCode() == otherPost.hashCode()
        );
    }

    private Post setUnmockedProperties(Post post) {
        post.setTitle(TITLE);
        post.setContent(CONTENT);
        post.setCreatedAt(CREATED_AT);
        post.setUpdatedAt(UPDATED_AT);

        return post;
    }
}
