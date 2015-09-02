package com.boredblog.controller.post;

import com.boredblog.config.JpaConfig;
import com.boredblog.config.RootConfig;
import com.boredblog.config.WebConfig;
import com.boredblog.controller.BaseJsonTest;
import com.boredblog.controller.PostController;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.entity.Post;
import com.boredblog.manager.PostManager;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Joel Dewey
 * @date 9/2/2015
 * Group: Joel
 * Verify that the JSON for fetching a post feed is correct.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        WebConfig.class,
        RootConfig.class,
        JpaConfig.class
})
public class PostControllerAllJsonTest extends PostControllerBaseJsonTest {
    @Before
    public void setup() throws Exception {
        instantiateDependentObjects();
        setDependentObjectFields();
        buildMockMvc();
        mockPostManager();
        sendRequestToRetrieveAll();
    }

    @Test
    public void testLengthOfArray() throws Exception {
        printJsonString(this.response, "/posts");
        this.response.andExpect(jsonPath(
                "$.*",
                hasSize(1)
        ));
    }

    @Test
    public void testLengthOfPostObject() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].*",
                hasSize(LENGTH_OF_ARRAY)
        ));
    }

    @Test
    public void testId() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].id",
                is(POST_ID)
        ));
    }

    @Test
    public void testTitle() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].title",
                is(POST_TITLE)
        ));
    }

    @Test
    public void testAuthor() throws Exception {
        this.response.andExpect(MockMvcResultMatchers.jsonPath(
                "$.[0].author.*",
                Matchers.hasSize(SIZE_OF_AUTHOR_OBJECT)
        ));
        this.response.andExpect(jsonPath(
                "$.[0].author.id",
                is(AUTHOR_ID)
        ));
        this.response.andExpect(jsonPath(
                "$.[0].author.screen_name",
                is(AUTHOR_SCREEN_NAME)
        ));
    }

    @Test
    public void testCreatedAt() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].created_at",
                is(POST_CREATED_AT)
        ));
    }

    @Test
    public void testUpdatedAt() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].updated_at",
                is(POST_UPDATED_AT)
        ));
    }

    private void instantiateDependentObjects() {
        this.postManager = Mockito.mock(PostManager.class);
        this.postController = new PostController(this.postManager);
        this.post = new Post();
        this.author = new Author();
        this.comment = new Comment();
    }

    private void setDependentObjectFields() {
        setAuthorFields();
        setCommentFields();
        setPostFields();
    }

    private void setAuthorFields() {
        this.author.setId(AUTHOR_ID);
        this.author.setFirstName(AUTHOR_FIRST_NAME);
        this.author.setLastName(AUTHOR_LAST_NAME);
        this.author.setScreenName(AUTHOR_SCREEN_NAME);
    }

    private void setCommentFields() {
        this.comment.setId(COMMENT_ID);
        this.comment.setAuthor(this.author);
        this.comment.setContent(COMMENT_CONTENT);
        this.comment.setCreatedAt(COMMENT_CREATED_AT);
    }

    private void setPostFields() {
        this.post.setId(POST_ID);
        this.post.setTitle(POST_TITLE);
        this.post.setContent(POST_CONTENT);
        this.post.setCreatedAt(new Timestamp(POST_CREATED_AT));
        this.post.setUpdatedAt(new Timestamp(POST_UPDATED_AT));
        this.post.setComments(Arrays.asList(this.comment));
        this.post.setAuthor(this.author);
    }

    private void buildMockMvc() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.postController)
                .setMessageConverters(this.jackson2HttpMessageConverter)
                .build();
    }

    private void mockPostManager() {
        Mockito.when(this.postManager.retrieveAll())
                .thenReturn(Arrays.asList(this.post));
    }

    private void sendRequestToRetrieveAll() throws Exception {
        this.response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/posts")
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
