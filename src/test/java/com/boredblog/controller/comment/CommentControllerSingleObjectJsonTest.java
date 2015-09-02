package com.boredblog.controller.comment;

import com.boredblog.config.JpaConfig;
import com.boredblog.config.RootConfig;
import com.boredblog.config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Joel Dewey
 * @date 9/2/2015
 * Group: Joel
 * Test the JSON response for a single Comment (/posts/{postId}/comments/{commentId})
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        WebConfig.class,
        RootConfig.class,
        JpaConfig.class
})
public class CommentControllerSingleObjectJsonTest
    extends CommentControllerBaseJsonTest {
    public static final int COMMENT_LENGTH = 4;

    @Before
    public void setup() throws Exception {
        instantiateDependentObjects();
        setCommentProperties();
        mockCommentManager();
        buildMockMvc();
        sendRequestToRetrieveSingle();
    }

    @Test
    public void testExpectedLength() throws Exception {
        this.printJsonString(this.response, "/posts/{postId}/comments/{commentId}");
        this.response.andExpect(jsonPath("$.*", hasSize(COMMENT_LENGTH)));
    }

    @Test
    public void testId() throws Exception{
        this.response.andExpect(jsonPath(
                "$.id",
                is(COMMENT_ID)
        ));
    }

    @Test
    public void testUser() throws Exception {
        this.response.andExpect(jsonPath(
                "$.user.id",
                is(AUTHOR_ID)
        ));
        this.response.andExpect(jsonPath(
                "$.user.screen_name",
                is(AUTHOR_SCREEN_NAME)
        ));
    }

    @Test
    public void testContent() throws Exception {
        this.response.andExpect(jsonPath(
                "$.content",
                is(COMMENT_CONTENT)
        ));
    }

    @Test
    public void testCreatedAt() throws Exception {
        this.response.andExpect(jsonPath(
                "$.created_at",
                is(COMMENT_CREATED_AT)
        ));
    }

    private void mockCommentManager() {
        Mockito.when(this.commentManager.retrieve(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(this.comment);
    }

    private void sendRequestToRetrieveSingle() throws Exception {
        this.response = this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/posts/"
                                + POST_ID
                                + "/comments/"
                                + COMMENT_ID
                ).accept(MediaType.APPLICATION_JSON));
    }
}
