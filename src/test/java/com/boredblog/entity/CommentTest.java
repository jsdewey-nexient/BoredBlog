package com.boredblog.entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that a Comment entity works as it should.
 */
public class CommentTest extends BaseTimestampTest {
    public static final int ID = 1;
    private final String CONTENT = "Lorem ipsum dolor sit amet, consectetur " +
            "adipiscing elit. Donec in.";
    @Mock
    private Author author;
    private Comment comment;

    @Before
    public void setup() throws Exception {
        this.comment = new Comment();

        MockitoAnnotations.initMocks(this);
        this.comment = this.setUnmockedProperties(this.comment);
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

    @Test
    public void testEquals() {
        Author author = new Author();
        Comment firstComment = new Comment();
        Comment secondComment = new Comment();
        firstComment = this.setUnmockedProperties(firstComment);
        firstComment.setUser(author);
        secondComment = this.setUnmockedProperties(secondComment);
        secondComment.setUser(author);

        assertTrue(
                "testEquals did not receive equal Comment objects.",
                firstComment.equals(secondComment)
                        && secondComment.equals(firstComment)
        );
    }

    @Test
    public void testHashCode() {
        Author author = this.createAuthor();
        Comment firstComment = new Comment();
        Comment secondComment = new Comment();
        firstComment = this.setUnmockedProperties(firstComment);
        firstComment.setUser(author);
        secondComment = this.setUnmockedProperties(secondComment);
        secondComment.setUser(author);

        assertTrue(
                "testHashCode did not receive equal hash codes from the " +
                        "Comment objects.",
                firstComment.hashCode() == secondComment.hashCode()
        );
    }

    private Comment setUnmockedProperties(Comment comment) {
        comment.setContent(CONTENT);
        comment.setCreatedAt(CREATED_AT);
        comment.setUpdatedAt(UPDATED_AT);
        comment.setId(ID);

        return comment;
    }

    private Author createAuthor() {
        Author author = new Author();
        author.setFirstName("Johnny");
        author.setLastName("Nexient");
        author.setScreenName("jnexient");
        author.setPassword("APoorPassword");
        author.setId(ID);
        author.setCreatedAt(CREATED_AT);
        author.setUpdatedAt(UPDATED_AT);

        return author;
    }
}
