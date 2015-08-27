package com.boredblog.controller;

import com.boredblog.config.WebConfig;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.entity.Post;
import com.boredblog.manager.AuthorManager;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/27/2015
 * Group: Joel
 * Validates that the JSON responses are valid.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class })
public class AuthorControllerJsonTest {
    @Mock
    private AuthorManager authorManager;
    @InjectMocks
    private AuthorController authorController;
    // Anything being serialized should not be mocked.
    private Author author;
    private List<Comment> comments;
    private List<Post> posts;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        addPostsToList();
        addCommentsToList();
        setAuthorProperties();
    }

    private void addPostsToList() {
        Post post = new Post();
        post.setContent("When a single Author is requested, only the " +
                "title of his or her last five posts may be shown.");
        for(int i = 0; i < 5; i++) {
            post.setTitle("Single Author Only: " + i);
            this.posts.add(post);
        }
    }

    private void addCommentsToList() {
        Comment comment = new Comment();
        comment.setContent("I should only be seen when a single Author " +
                "is requested.");
        for(int i = 0; i < 5; i++) {
            this.comments.add(comment);
        }
    }

    private void setAuthorProperties() {
        this.author.setId(1);
        this.author.setFirstName("Johnny");
        this.author.setLastName("Nexient");
        this.author.setScreenName("jnexient");
        this.author.setPassword("Shouldn't see this!");
        this.author.setCreatedAt(new Timestamp(1));
        this.author.setUpdatedAt(new Timestamp(2));
        this.author.setComments(this.comments);
        this.author.setPosts(this.posts);
    }
}
