package com.boredblog.manager;

import com.boredblog.entity.Post;
import com.boredblog.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Joel Dewey
 * @date 8/24/2015
 * Group: Joel
 * Verify that the PostManager is working correctly.
 */
public class PostManagerTest {
    private final Integer POST_ID = 1;
    @Mock
    private PostRepository postRepository;
    @Mock
    private List<Post> posts;
    @InjectMocks
    private PostManager postManager;
    private Post post;
    private Post updatedPost;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.createDependentObjects();
        this.setDependentObjectProperties();
        this.mockPostRepository();
    }

    @Test
    public void testCreatePost() {
        Post result = this.postManager.create(this.post);

        assertEquals(
                "testCreatePost did not receive the expected Post object.",
                this.post,
                result
        );
    }

    @Test
    public void testRetrievingSinglePost() {
        Post result = this.postManager.retrieve(POST_ID);

        assertEquals(
                "testRetrievingSinglePost did not receive the expected " +
                        "Post object.",
                this.post,
                result
        );
    }

    @Test
    public void testRetrievingAllPosts() {
        List<Post> result = this.postManager.retrieveAll();

        assertEquals(
                "testRetrievingAllPosts did not receive the expected List back.",
                this.posts,
                result
        );
    }

    @Test
    public void testUpdatingPost() {
        String originalContent = this.post.getContent();
        String updatedContent = null;
        this.postManager.update(POST_ID, this.updatedPost);
        updatedContent = this.post.getContent();

        assertNotEquals(
                "testUpdatingPost received null.",
                null,
                updatedContent
        );

        assertNotEquals(
                "testUpdatingPost received the same string back.",
                originalContent,
                updatedContent
        );
    }

    private void createDependentObjects() {
        this.post = new Post();
        this.updatedPost = new Post();
    }

    private void setDependentObjectProperties() {
        this.post.setContent("Hello!");
        this.updatedPost.setContent("Good bye!");
    }

    private void mockPostRepository() {
        Mockito.when(this.postRepository.save(this.post))
                .thenReturn(this.post);
        Mockito.when(this.postRepository.findOne(POST_ID))
                .thenReturn(this.post);
        Mockito.when(this.postRepository.findAll())
                .thenReturn(this.posts);
    }
}
