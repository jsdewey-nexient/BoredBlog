package com.boredblog.controller.comment;

import com.boredblog.controller.BaseJsonTest;
import com.boredblog.controller.CommentController;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.manager.CommentManager;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
    public static final String COMMENT_SCREEN_NAME = "jnexient";
    protected CommentController commentController;
    protected CommentManager commentManager;
    protected Comment comment;
    protected Author author;

    @Autowired
    protected MappingJackson2HttpMessageConverter jackson2HttpMessageConverter;
    protected MockMvc mockMvc;
    protected ResultActions response;

    protected void setCommentProperties() {
        this.comment.setId(COMMENT_ID);
        this.comment.setContent(COMMENT_CONTENT);
        this.comment.setCreatedAt(new Timestamp(COMMENT_CREATED_AT));
        this.comment.setAuthor(this.author);
    }

    protected void instantiateDependentObjects() {
        this.commentManager = Mockito.mock(CommentManager.class);
        this.comment = new Comment();
        this.commentController = new CommentController(this.commentManager);
        this.author = new Author();
        this.author.setScreenName(COMMENT_SCREEN_NAME);
    }

    protected void sendRequestToRetrieveAll() throws Exception {
        this.response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/posts/" + POST_ID + "/comments")
                        .accept(MediaType.APPLICATION_JSON)
        );
    }

    protected void buildMockMvc() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CommentController(this.commentManager))
                .setMessageConverters(this.jackson2HttpMessageConverter)
                .build();
    }
}
