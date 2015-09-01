package com.boredblog.controller.author;

import com.boredblog.config.JpaConfig;
import com.boredblog.config.RootConfig;
import com.boredblog.config.WebConfig;
import com.boredblog.entity.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Timestamp;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Joel Dewey
 * @date 8/27/2015
 * Group: Joel
 * Validates that the JSON response for /authors is correct.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
/**
 * @todo Figure out why MockMvc has to hit the DB for the test to run correctly.
 */
@ContextConfiguration(classes = {
        WebConfig.class,
        RootConfig.class,
        JpaConfig.class
})
public class AuthorControllerAllEndpointJsonTest
        extends AuthorControllerBaseJsonTest {
    public static final int SIZE_OF_JSON_OBJECT = 3;
    public static final int SIZE_OF_RESPONSE = 2;
    // Anything being serialized should not be mocked.
    private Author secondAuthor;
    private final int SECOND_AUTHOR_ID = 2;
    private final String SECOND_AUTHOR_FIRST_NAME = "Jackson";
    private final String SECOND_AUTHOR_LAST_NAME = "FasterXML";
    private final String SECOND_AUTHOR_SCREEN_NAME = "Codehaus";
    private final String SECOND_AUTHOR_PASSWORD = "Shouldn't see this!";

    @Before
    public void setup() throws Exception {
        instantiateDependentObjects();
        buildMockMvc();
        addPostsToList();
        addCommentsToList();
        setFirstAuthorProperties();
        setSecondAuthorProperties();
        mockAuthorManager();
        sendRequestToRetrieveAll();
    }

    @Test
    public void testSuccessfulRequest() throws Exception{
        printJsonString(this.response, "/authors");
        super.testSuccessfulRequest(this.response);
    }

    @Test
    public void testCorrectLength() throws Exception {
        this.response
                .andExpect(jsonPath("$.*", hasSize(SIZE_OF_RESPONSE)));
    }

    @Test
    public void testIds() throws Exception {
        this.response
                .andExpect(jsonPath("$.[0].id", is(FIRST_AUTHOR_ID)))
                .andExpect(jsonPath("$.[1].id", is(SECOND_AUTHOR_ID)));
    }

    @Test
    public void testScreenNames() throws Exception {
        this.response
                .andExpect(jsonPath(
                        "$.[0].screen_name",
                        is(FIRST_AUTHOR_SCREEN_NAME)
                ))
                .andExpect(jsonPath(
                        "$.[1].screen_name",
                        is(SECOND_AUTHOR_SCREEN_NAME)
                ));
    }

    @Test
    public void testNames() throws Exception {
        this.response
                .andExpect(jsonPath(
                        "$.[0].user",
                        is(
                                FIRST_AUTHOR_FIRST_NAME
                                        + " "
                                        + FIRST_AUTHOR_LAST_NAME
                        )
                ))
                .andExpect(jsonPath(
                        "$.[1].user",
                        is(
                                SECOND_AUTHOR_FIRST_NAME
                                        + " "
                                        + SECOND_AUTHOR_LAST_NAME
                        )
                ));
    }

    @Test
    public void testObjectLength() throws Exception {
        this.response.andExpect(jsonPath(
                "$.[0].*",
                hasSize(SIZE_OF_JSON_OBJECT)
        ));
        this.response.andExpect(jsonPath(
                "$.[1].*",
                hasSize(SIZE_OF_JSON_OBJECT)
        ));
    }

    public void instantiateDependentObjects() {
        super.instantiateDependentObjects();
        this.secondAuthor = new Author();
    }

    private void setSecondAuthorProperties() {
        this.secondAuthor.setId(SECOND_AUTHOR_ID);
        this.secondAuthor.setFirstName(SECOND_AUTHOR_FIRST_NAME);
        this.secondAuthor.setLastName(SECOND_AUTHOR_LAST_NAME);
        this.secondAuthor.setScreenName(SECOND_AUTHOR_SCREEN_NAME);
        this.secondAuthor.setPassword(SECOND_AUTHOR_PASSWORD);
        this.secondAuthor.setCreatedAt(new Timestamp(3));
        this.secondAuthor.setUpdatedAt(new Timestamp(4));
        this.secondAuthor.setComments(this.comments);
        this.secondAuthor.setPosts(this.posts);
        addAuthorToList(this.secondAuthor);
    }

    private void sendRequestToRetrieveAll() throws Exception {
        this.response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/authors")
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
