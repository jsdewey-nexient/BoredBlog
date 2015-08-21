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

    }

    @Test
    public void testUpdatingComment() {

    }

    @Test
    public void testRetrievingAllCommentsForPost() {

    }

    @Test
    public void testRetrievingSingleCommentForPost() {

    }

    private void mockCommentManager() {
        Mockito.when(this.commentManager.retrieve(POST_ID, COMMENT_ID))
                .thenReturn(this.comment);
        Mockito.when(this.commentManager.create(POST_ID, this.comment))
                .thenReturn(this.comment);
        Mockito.when(this.commentManager.update(POST_ID, this.comment))
                .thenReturn(this.updatedComment);
        Mockito.when(this.commentManager.retrieveAll(POST_ID))
                .thenReturn(this.comments);
    }
}
