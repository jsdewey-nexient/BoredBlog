package com.boredblog.controller;

import com.boredblog.config.JpaConfig;
import com.boredblog.config.RootConfig;
import com.boredblog.config.WebAppInitializer;
import com.boredblog.config.WebConfig;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.entity.Post;
import com.boredblog.manager.AuthorManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    public static final int SIZE_OF_JSON_OBJECT = 4;
    public static final int SIZE_OF_RESPONSEALL_ARRAY = 2;
    // Anything being serialized should not be mocked.
    private Author secondAuthor;
    private ResultActions responseAll;

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
    public void testSuccessfulResponseAll() throws Exception{
        this.testSuccessfulResponse(this.responseAll);
    }

    @Test
    public void testResponseAllCorrectLength() throws Exception {
        this.responseAll
                .andExpect(jsonPath("$.*", hasSize(SIZE_OF_RESPONSEALL_ARRAY)));
    }

    @Test
    public void testResponseAllIds() throws Exception {
        this.responseAll
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[1].id", is(2)));
    }

    @Test
    public void testResponseAllScreenNames() throws Exception {
        this.responseAll
                .andExpect(jsonPath("$.[0].screen_name", is("jnexient")))
                .andExpect(jsonPath("$.[1].screen_name", is("Codehaus")));
    }

    @Test
    public void testResponseAllFirstNames() throws Exception {
        this.responseAll
                .andExpect(jsonPath("$.[0].first_name", is("Johnny")))
                .andExpect(jsonPath("$.[1].first_name", is("Jackson")));
    }

    @Test
    public void testResponseAllLastNames() throws Exception {
        this.responseAll
                .andExpect(jsonPath("$.[0].last_name", is("Nexient")))
                .andExpect(jsonPath("$.[1].last_name", is("FasterXML")));
    }

    @Test
    public void testResponseAllObjectLength() throws Exception {
        this.responseAll.andExpect(jsonPath("$.[0].*", hasSize(SIZE_OF_JSON_OBJECT)));
        this.responseAll.andExpect(jsonPath("$.[1].*", hasSize(SIZE_OF_JSON_OBJECT)));
    }

    public void instantiateDependentObjects() {
        super.instantiateDependentObjects();
        this.secondAuthor = new Author();
    }

    private void setSecondAuthorProperties() {
        this.secondAuthor.setId(2);
        this.secondAuthor.setFirstName("Jackson");
        this.secondAuthor.setLastName("FasterXML");
        this.secondAuthor.setScreenName("Codehaus");
        this.secondAuthor.setPassword("Shouldn't see this!");
        this.secondAuthor.setCreatedAt(new Timestamp(3));
        this.secondAuthor.setUpdatedAt(new Timestamp(4));
        this.secondAuthor.setComments(this.comments);
        this.secondAuthor.setPosts(this.posts);
        addAuthorToList(this.secondAuthor);
    }

    private void sendRequestToRetrieveAll() throws Exception {
        this.responseAll = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/authors")
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
