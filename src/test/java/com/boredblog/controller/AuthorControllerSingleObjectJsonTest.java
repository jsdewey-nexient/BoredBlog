package com.boredblog.controller;

import com.boredblog.config.JpaConfig;
import com.boredblog.config.RootConfig;
import com.boredblog.config.WebConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
    private ResultActions responseSingle;

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

    private void sendRequestToRetrieveSingleAuthor() throws Exception {
        this.responseSingle = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/authors/1")
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
