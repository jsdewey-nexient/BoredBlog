package com.boredblog.controller;

import com.boredblog.config.RootConfig;
import com.boredblog.config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Joel Dewey
 * @date 9/1/2015
 * Group: Joel
 * Validates a JSON response from a single object endpoint (/authors/{id}).
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        WebConfig.class,
        RootConfig.class
})
public class AuthorControllerSingleObjectJsonTest
        extends AuthorControllerBaseJsonTest {
    public static final int AUTHOR_ID = 1;
    public final int SIZE_OF_RESPONSE = 6;

    @Before
    public void setup() throws Exception {
        instantiateDependentObjects();
        buildMockMvc();
        addPostsToList();
        addCommentsToList();
        setFirstAuthorProperties();
        mockAuthorManager();
        sendRequestToRetrieveSingleAuthor();
    }

    @Test
    public void testSuccessfulRequest() throws Exception {
        super.testSuccessfulRequest(this.response);
    }

    @Test
    public void testCorrectLength() throws Exception {
        this.response.andExpect(jsonPath("$.*", hasSize(SIZE_OF_RESPONSE)));
    }

    @Test
    public void testId() throws Exception {
        this.response.andExpect(jsonPath("$.id", is(AUTHOR_ID)));
    }

    @Test
    public void testScreenName() throws Exception {

    }

    private void sendRequestToRetrieveSingleAuthor() throws Exception {
        this.response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/authors/" + AUTHOR_ID)
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
