package com.boredblog.controller.comment;

import com.boredblog.config.JpaConfig;
import com.boredblog.config.RootConfig;
import com.boredblog.config.WebConfig;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
    public void testUser() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].user.id",
                is(AUTHOR_ID)
        ));
        this.response.andExpect(jsonPath(
                "$.[0].user.screen_name",
                is(AUTHOR_SCREEN_NAME)
        ));
        this.response.andExpect(MockMvcResultMatchers.jsonPath(
                "$.[0].user.*",
                Matchers.hasSize(LENGTH_OF_USER_OBJECT)
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

    private void mockCommentManager() {
        Mockito.when(this.commentManager.retrieveAll(Mockito.anyInt()))
                .thenReturn(Arrays.asList(this.comment));
    }

    protected void sendRequestToRetrieveAll() throws Exception {
        this.response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/posts/" + POST_ID + "/comments")
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
