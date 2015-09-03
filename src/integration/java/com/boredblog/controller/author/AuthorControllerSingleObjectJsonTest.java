package com.boredblog.controller.author;

import com.boredblog.config.JpaConfig;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
        RootConfig.class,
        JpaConfig.class
})
public class AuthorControllerSingleObjectJsonTest
        extends AuthorControllerBaseJsonTest {
    public final int SIZE_OF_RESPONSE = 5;
    public final int SIZE_OF_COMMENT_LIST = 1;
    public final int SIZE_OF_POST_LIST = 1;
    public final int SIZE_OF_COMMENT = 3;
    public final int SIZE_OF_POST = 4;

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
        printJsonString(this.response, "/authors/{id}");
        super.testSuccessfulRequest(this.response);
    }

    @Test
    public void testCorrectLength() throws Exception {
        this.response.andExpect(jsonPath("$.*", hasSize(SIZE_OF_RESPONSE)));
    }

    @Test
    public void testId() throws Exception {
        this.response.andExpect(jsonPath("$.id", is(FIRST_AUTHOR_ID)));
    }

    @Test
    public void testScreenName() throws Exception {
        this.response.andExpect(jsonPath(
                "$.screen_name",
                is(FIRST_AUTHOR_SCREEN_NAME)
        ));
    }

    @Test
    public void testUser() throws Exception {
        this.response.andExpect(jsonPath(
                "$.user",
                is(FIRST_AUTHOR_FIRST_NAME + " " + FIRST_AUTHOR_LAST_NAME)
        ));
    }

    @Test
    public void testCommentListLength() throws Exception {
        this.response.andExpect(jsonPath(
                "$.comments.*",
                hasSize(SIZE_OF_COMMENT_LIST)
        ));
    }

    @Test
    public void testPostListLength() throws Exception {
        this.response.andExpect(jsonPath(
                "$.posts.*",
                hasSize(SIZE_OF_POST_LIST)
        ));
    }

    @Test
    public void testPostObjectLength() throws Exception {
        this.response.andExpect(jsonPath(
                "$.posts[0].*",
                hasSize(SIZE_OF_POST)
        ));
    }

    @Test
    public void testCommentObjectLength() throws Exception {
        this.response.andExpect(jsonPath(
                "$.comments[0].*",
                hasSize(SIZE_OF_COMMENT)
        ));
    }

    private void sendRequestToRetrieveSingleAuthor() throws Exception {
        this.response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/authors/" + FIRST_AUTHOR_ID)
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
