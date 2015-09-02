package com.boredblog.controller.comment;

import com.boredblog.config.JpaConfig;
import com.boredblog.config.RootConfig;
import com.boredblog.config.WebConfig;
import com.boredblog.controller.AuthorController;
import com.boredblog.controller.BaseJsonTest;
import com.boredblog.controller.CommentController;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.manager.CommentManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Joel Dewey
 * @date 9/1/2015
 * Group: Joel
 * Validate the JSON response when retrieving all comments for a post.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        WebConfig.class,
        RootConfig.class,
        JpaConfig.class
})
public class CommentControllerAllJsonTest extends CommentControllerBaseJsonTest {
    @Before
    public void setup() throws Exception {
        instantiateDependentObjects();
        setCommentProperties();
        mockCommentManager();
        buildMockMvc();
        sendRequestToRetrieveAll();
    }

    @Test
    public void testIsArrayOfSizeOne() throws Exception {
        this.printJsonString(this.response, "/posts/{id}/comments");
        this.response.andExpect(jsonPath("$.*", hasSize(1)));
    }

    @Test
    public void testId() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].id",
                is(COMMENT_ID)
        ));
    }

    @Test
    public void testScreenName() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].screen_name",
                is(COMMENT_SCREEN_NAME)
        ));
    }

    @Test
    public void testContent() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].content",
                is(COMMENT_CONTENT)
        ));
    }

    @Test
    public void testCreatedAt() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].created_at",
                is(COMMENT_CREATED_AT)
        ));
    }

    private void sendRequestToRetrieveAll() throws Exception {
        this.response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/posts/" + POST_ID + "/comments")
                        .accept(MediaType.APPLICATION_JSON)
        );
    }

    private void buildMockMvc() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CommentController(this.commentManager))
                .setMessageConverters(this.jackson2HttpMessageConverter)
                .build();
    }

    private void mockCommentManager() {
        Mockito.when(this.commentManager.retrieveAll(Mockito.anyInt()))
                .thenReturn(Arrays.asList(this.comment));
    }

    private void setCommentProperties() {
        this.comment.setId(COMMENT_ID);
        this.comment.setContent(COMMENT_CONTENT);
        this.comment.setCreatedAt(new Timestamp(COMMENT_CREATED_AT));
        this.comment.setAuthor(this.author);
    }

    private void instantiateDependentObjects() {
        this.commentManager = Mockito.mock(CommentManager.class);
        this.comment = new Comment();
        this.commentController = new CommentController(this.commentManager);
        this.author = new Author();
        this.author.setScreenName(COMMENT_SCREEN_NAME);
    }
}
