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
