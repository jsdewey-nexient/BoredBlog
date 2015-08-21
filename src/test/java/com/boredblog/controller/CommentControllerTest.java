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
    public void testRetrievingSingleComment() {

    }
}
