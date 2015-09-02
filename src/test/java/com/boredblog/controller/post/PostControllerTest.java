package com.boredblog.controller.post;

import com.boredblog.controller.PostController;
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
    private final Integer POST_ID = 1;
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
    public void testRetrievingSinglePost() {
        Post result = this.postController.getPost(POST_ID);

        assertEquals("testRetrievingOnePost did not receive the Post " +
                "object back.", this.post, result);
        Mockito.verify(this.postManager).retrieve(POST_ID);
    }

    @Test
    public void testCreatingNewPost() {
        Post result = this.postController.createPost(this.post);

        assertEquals("testCreatingNewPost did not receive its Post " +
                "object back.", this.post, result);
        Mockito.verify(this.postManager).create(this.post);
    }

    @Test
    public void testUpdatingPost() {
        Post result = this.postController.updatePost(POST_ID, this.post);

        assertEquals("testUpdatingPost did not receive updated Post " +
                "object back.", this.updatePost, result);
        Mockito.verify(this.postManager).update(POST_ID, this.post);
    }

    private void mockPostManager() {
        Mockito.when(postManager.create(this.post))
                .thenReturn(this.post);
        Mockito.when(postManager.retrieve(POST_ID))
                .thenReturn(this.post);
        Mockito.when(postManager.update(POST_ID, this.post))
                .thenReturn(this.updatePost);
        Mockito.when(postManager.retrieveAll())
                .thenReturn(this.posts);
    }
}
