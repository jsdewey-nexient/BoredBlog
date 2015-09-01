package com.boredblog.controller;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Joel Dewey
 * @date 9/1/2015
 * Group: Joel
 * Validates a JSON response from a single object endpoint (/authors/{id}).
 */
public class AuthorControllerSingleObjectJsonTest
        extends AuthorControllerBaseJsonTest {
    private ResultActions responseSingle;

    private void sendRequestToRetrieveSingleAuthor() throws Exception {
        this.responseSingle = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/authors/1")
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
