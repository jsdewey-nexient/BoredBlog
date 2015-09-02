package com.boredblog.controller.comment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Joel Dewey
 * @date 9/2/2015
 * Group: Joel
 * Test the JSON response for a single Comment (/posts/{postId}/comments/{commentId})
 */
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
