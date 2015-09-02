package com.boredblog.controller.post;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

/**
 * @author Joel Dewey
 * @date 9/2/2015
 * Group: Joel
 * Test retrieving a single Post's JSON.
 */
public class PostControllerSingleObjectJsonTest extends PostControllerBaseJsonTest {

    private void mockPostManager() {
        Mockito.when(this.postManager.retrieve(Mockito.anyInt()))
                .thenReturn(this.post);
    }

    private void sendRequestToRetrieveAll() throws Exception {
        this.response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/posts/" + POST_ID)
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
