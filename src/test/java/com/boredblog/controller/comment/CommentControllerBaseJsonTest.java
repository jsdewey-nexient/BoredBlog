package com.boredblog.controller.comment;

import com.boredblog.controller.BaseJsonTest;
import com.boredblog.controller.CommentController;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.manager.CommentManager;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;

/**
 * @author Joel Dewey
 * @date 9/2/2015
 * Group: Joel
 * A class with shared setup methods.
 */
public class CommentControllerBaseJsonTest extends BaseJsonTest {
    public static final int POST_ID = 1;
    public static final int COMMENT_ID = 1;
    public static final String COMMENT_CONTENT = "Do you see me?";
    public static final int COMMENT_CREATED_AT = 123456789;
    public static final String AUTHOR_SCREEN_NAME = "jnexient";
    public static final int AUTHOR_ID = 1;
    protected CommentManager commentManager;
    protected Comment comment;
    protected Author author;

    protected void setCommentProperties() {
        this.comment.setId(COMMENT_ID);
        this.comment.setContent(COMMENT_CONTENT);
        this.comment.setCreatedAt(new Timestamp(COMMENT_CREATED_AT));
        this.comment.setAuthor(this.author);
    }

    protected void instantiateDependentObjects() {
        this.commentManager = Mockito.mock(CommentManager.class);
        this.comment = new Comment();
        this.author = new Author();
        this.author.setId(AUTHOR_ID);
        this.author.setScreenName(AUTHOR_SCREEN_NAME);
        this.author.setFirstName("Johnny");
        this.author.setLastName("Nexient");
    }

    protected void buildMockMvc() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CommentController(this.commentManager))
                .setMessageConverters(this.jackson2HttpMessageConverter)
                .build();
    }
}
