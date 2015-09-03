package com.boredblog.manager;

import com.boredblog.entity.Comment;
import com.boredblog.repository.CommentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Joel Dewey
 * @date 8/24/2015
 * Group: Joel
 * Verify the behavior of the CommentManager.
 */
public class CommentManagerTest {
    private final Integer POST_ID = 1;
    private final Integer COMMENT_ID = 1;
    @Mock
    private CommentRepository commentRepository;
    @Mock
    private List<Comment> commentList;
    @InjectMocks
    private CommentManager commentManager;
    private Comment comment;
    private Comment updatedComment;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        instantiateDependencies();
        mockCommentRepository();
        setCommentProperties();
    }

    @Test
    public void testCreateComment() {
        Comment result = this.commentManager.create(POST_ID, this.comment);

        assertEquals(
                "testCreateComment did not receive the same Comment object " +
                        "back.",
                this.comment,
                result
        );
    }

    @Test
    public void testRetrievingSingleComment() {
        Comment result = this.commentManager.retrieve(POST_ID, COMMENT_ID);

        assertEquals(
                "testRetrievingSingleComment did not receive the expected " +
                        "Comment object.",
                this.comment,
                result
        );
    }

    @Test
    public void testRetrievingAllComments() {
        List<Comment> result = this.commentManager.retrieveAll(POST_ID);

        assertEquals(
                "testRetrievingAllComments did not receive the expected " +
                        "List object back.",
                this.commentList,
                result
        );
    }

    @Test
    public void testUpdatingComment() {
        String originalValue = comment.getContent();
        String updatedValue = null;
        this.commentManager.update(
                POST_ID,
                COMMENT_ID,
                updatedComment
        );
        updatedValue = comment.getContent();

        assertNotEquals(
                "testUpdatingComment receive null as the updated content.",
                null,
                updatedValue
        );

        assertNotEquals(
                "testUpdatingComment received the same content string back.",
                originalValue,
                updatedValue
        );
    }

    private void instantiateDependencies() {
        this.comment = new Comment();
        this.updatedComment = new Comment();
    }

    private void setCommentProperties() {
        this.comment.setContent("Hello!");
        this.updatedComment.setContent("Good bye!");
    }

    private void mockCommentRepository() {
        Mockito.when(this.commentRepository.save(this.comment))
                .thenReturn(this.comment);
        Mockito.when(this.commentRepository.findOne(COMMENT_ID))
                .thenReturn(this.comment);
        Mockito.when(this.commentRepository.findAll())
                .thenReturn(this.commentList);
    }
}
