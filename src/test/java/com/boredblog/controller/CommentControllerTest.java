package com.boredblog.controller;

import com.boredblog.entity.Comment;
import com.boredblog.manager.CommentManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that comments are returned correctly.
 */
public class CommentControllerTest {
    private final Integer POST_ID = 1;
    private final Integer COMMENT_ID = 1;
    @Mock
    private List<Comment> comments;
    @Mock
    private Comment comment;
    @Mock
    private Comment updatedComment;
    @Mock
    private CommentManager commentManager;
    @InjectMocks
    private CommentController commentController;

    @Before
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
        this.mockCommentManager();
    }

    @Test
    public void testCreatingComment() {
        Comment result = this.commentController.createComment(
                POST_ID,
                this.comment
        );

        assertEquals("testCreatingComment did not receive the proper " +
                "Comment object back.", this.comment, result);
        Mockito.verify(this.commentManager).create(POST_ID, this.comment);
    }

    @Test
    public void testUpdatingComment() {
        Comment result = this.commentController.updateComment(
                POST_ID,
                COMMENT_ID,
                this.comment
        );

        assertEquals("testUpdatingComment did not receive the updated " +
                "Comment object back.", this.updatedComment, result);
        Mockito.verify(this.commentManager).update(
                POST_ID,
                COMMENT_ID,
                this.comment
        );
    }

    @Test
    public void testRetrievingAllCommentsForPost() {
        List<Comment> result = this.commentController.getComments(POST_ID);

        assertEquals("testRetrievingAllCommentsForPost did not receive the " +
                "List of Comments back.", this.comments, result);
        Mockito.verify(this.commentManager).retrieveAll(POST_ID);
    }

    @Test
    public void testRetrievingSingleCommentForPost() {
        Comment result = this.commentController.getComment(POST_ID, COMMENT_ID);

        assertEquals("testRetrievingSingleCommentForPost did not receive the " +
                "correct Comment object back.", this.comment, result);
        Mockito.verify(this.commentManager).retrieve(POST_ID, COMMENT_ID);
    }

    private void mockCommentManager() {
        Mockito.when(this.commentManager.retrieve(POST_ID, COMMENT_ID))
                .thenReturn(this.comment);
        Mockito.when(this.commentManager.create(POST_ID, this.comment))
                .thenReturn(this.comment);
        Mockito.when(this.commentManager.update(
                POST_ID,
                COMMENT_ID,
                this.comment
        ))
                .thenReturn(this.updatedComment);
        Mockito.when(this.commentManager.retrieveAll(POST_ID))
                .thenReturn(this.comments);
    }
}
