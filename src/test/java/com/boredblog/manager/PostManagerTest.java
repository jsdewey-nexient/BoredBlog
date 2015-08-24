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
    @InjectMocks
    private PostManager postManager;
    private Post post;
    private Post updatedPost;
    private List<Post> posts;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.createDependentObjects();
        this.setDependentObjectProperties();
        this.mockPostRepository();
    }

    @Test
    public void testCreatePost() {

    }

    @Test
    public void testRetrievingSinglePost() {

    }

    @Test
    public void testRetrievingAllPosts() {

    }

    @Test
    public void testUpdatingPost() {

    }

    private void createDependentObjects() {
        this.post = new Post();
        this.updatedPost = new Post();
        this.posts = new ArrayList<Post>();
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
