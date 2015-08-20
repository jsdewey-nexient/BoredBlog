package com.boredblog.controller;

import com.boredblog.entity.Post;
import com.boredblog.manager.PostManager;
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
 * @date 8/20/2015
 * Group: Joel
 * Tests the functions of the PostController
 */
public class PostControllerTest {
    @Mock
    private Post post;
    @Mock
    private Post updatePost;
    @Mock
    private List<Post> posts;
    @Mock
    private PostManager postManager;
    @InjectMocks
    private PostController postController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockPostManager();
    }

    @Test
    public void testRetrievingAllPosts() {
        List<Post> result = this.postController.getPosts();

        assertEquals("testRetrievingAllPosts did not receive the List of " +
                "Post objects back.", this.posts, result);
        Mockito.verify(this.postManager).retrieveAll();
    }
    
    @Test
    public void testRetrievingOnePost() {
        Post result = this.postController.getPost(1);

        assertEquals("testRetrievingOnePost did not receive the Post " +
                "object back.", this.post, result);
    }

    private void mockPostManager() {
        Mockito.when(postManager.create(this.post))
                .thenReturn(this.post);
        Mockito.when(postManager.retrieve(1))
                .thenReturn(this.post);
        Mockito.when(postManager.update(1, this.post))
                .thenReturn(this.updatePost);
        Mockito.when(postManager.retrieveAll())
                .thenReturn(this.posts);
    }
}