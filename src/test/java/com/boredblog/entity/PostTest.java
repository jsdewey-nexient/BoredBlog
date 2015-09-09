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
    public static final int ID = 1;
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
        Post firstPost = this.setUnmockedProperties(new Post());
        Post secondPost = this.setUnmockedProperties(new Post());

        assertTrue(
                "The two Post objects in testEquals are not equal.",
                firstPost.equals(secondPost) && secondPost.equals(firstPost)
        );
    }

    @Test
    public void testHashCode() {
        Post firstPost = this.setUnmockedProperties(new Post());
        Post secondPost = this.setUnmockedProperties(new Post());

        assertTrue(
                "The hash codes of the two Post objects in testHashCode " +
                        "are not the same.",
                firstPost.hashCode() == secondPost.hashCode()
        );
    }

    private Post setUnmockedProperties(Post post) {
        Author author = new Author();

        post.setId(ID);
        post.setTitle(TITLE);
        post.setContent(CONTENT);
        post.setCreatedAt(CREATED_AT);
        post.setUpdatedAt(UPDATED_AT);

        author.setId(ID);
        author.setFirstName("Johnny");
        author.setLastName("Nexient");
        author.setPassword("A long password hash.");
        author.setScreenName("jnexient");
        author.setCreatedAt(CREATED_AT);

        post.setAuthor(author);

        return post;
    }
}
