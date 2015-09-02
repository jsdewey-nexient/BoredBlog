package com.boredblog.controller.post;

import com.boredblog.controller.BaseJsonTest;
import com.boredblog.controller.PostController;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.entity.Post;
import com.boredblog.manager.PostManager;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 * @author Joel Dewey
 * @date 9/2/2015
 * Group: Joel
 * A class containing shared methods.
 */
public class PostControllerBaseJsonTest extends BaseJsonTest {
    public static final int AUTHOR_ID = 1;
    public static final String AUTHOR_FIRST_NAME = "Johnny";
    public static final String AUTHOR_LAST_NAME = "Nexient";
    public static final String AUTHOR_SCREEN_NAME = "jnexient";
    public static final int COMMENT_ID = 1;
    public static final String COMMENT_CONTENT = "Hello!";
    public static final Timestamp COMMENT_CREATED_AT = new Timestamp(13500000);
    public static final int POST_ID = 1;
    public static final String POST_TITLE = "The title that should be seen.";
    public static final String POST_CONTENT = "The content that should be seen.";
    public static final int POST_CREATED_AT = 13000000;
    public static final int POST_UPDATED_AT = 14000000;
    public static final int LENGTH_OF_OBJECT = 5;
    public static final int SIZE_OF_AUTHOR_OBJECT = 2;
    protected PostController postController;
    protected PostManager postManager;
    protected Post post;
    protected Author author;
    protected Comment comment;

    protected void instantiateDependentObjects() {
        this.postManager = Mockito.mock(PostManager.class);
        this.postController = new PostController(this.postManager);
        this.post = new Post();
        this.author = new Author();
        this.comment = new Comment();
    }

    protected void setDependentObjectFields() {
        setAuthorFields();
        setCommentFields();
        setPostFields();
    }

    protected void setAuthorFields() {
        this.author.setId(AUTHOR_ID);
        this.author.setFirstName(AUTHOR_FIRST_NAME);
        this.author.setLastName(AUTHOR_LAST_NAME);
        this.author.setScreenName(AUTHOR_SCREEN_NAME);
    }

    protected void setCommentFields() {
        this.comment.setId(COMMENT_ID);
        this.comment.setUser(this.author);
        this.comment.setContent(COMMENT_CONTENT);
        this.comment.setCreatedAt(COMMENT_CREATED_AT);
    }

    protected void setPostFields() {
        this.post.setId(POST_ID);
        this.post.setTitle(POST_TITLE);
        this.post.setContent(POST_CONTENT);
        this.post.setCreatedAt(new Timestamp(POST_CREATED_AT));
        this.post.setUpdatedAt(new Timestamp(POST_UPDATED_AT));
        this.post.setComments(Arrays.asList(this.comment));
        this.post.setAuthor(this.author);
    }

    protected void buildMockMvc() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.postController)
                .setMessageConverters(this.jackson2HttpMessageConverter)
                .build();
    }
}
