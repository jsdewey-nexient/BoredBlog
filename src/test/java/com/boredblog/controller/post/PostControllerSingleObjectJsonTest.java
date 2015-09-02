package com.boredblog.controller.post;

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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author Joel Dewey
 * @date 9/2/2015
 * Group: Joel
 * Test retrieving a single Post's JSON.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        WebConfig.class,
        RootConfig.class,
        JpaConfig.class
})
public class PostControllerSingleObjectJsonTest extends PostControllerBaseJsonTest {

    @Before
    public void setup() throws Exception {
        instantiateDependentObjects();
        setDependentObjectFields();
        buildMockMvc();
        mockPostManager();
        sendRequestToRetrieveSingle();
    }

    @Test
    public void testLengthOfArray() throws Exception {
        printJsonString(this.response, "/posts");
        this.response.andExpect(jsonPath(
                "$.*",
                hasSize(LENGTH_OF_OBJECT)
        ));
    }

    @Test
    public void testId() throws Exception {
        this.response.andExpect(jsonPath(
                "$.id",
                is(POST_ID)
        ));
    }

    @Test
    public void testTitle() throws Exception {
        this.response.andExpect(jsonPath(
                "$.title",
                is(POST_TITLE)
        ));
    }

    @Test
    public void testContent() throws Exception {
        this.response.andExpect(jsonPath(
                "$.content",
                is(POST_CONTENT)
        ));
    }

    @Test
    public void testAuthor() throws Exception {
        this.response.andExpect(MockMvcResultMatchers.jsonPath(
                "$.author.*",
                Matchers.hasSize(SIZE_OF_AUTHOR_OBJECT)
        ));
        this.response.andExpect(jsonPath(
                "$.author.id",
                is(AUTHOR_ID)
        ));
        this.response.andExpect(jsonPath(
                "$.author.screen_name",
                is(AUTHOR_SCREEN_NAME)
        ));
    }

    @Test
    public void testCreatedAt() throws Exception {
        this.response.andExpect(jsonPath(
                "$.created_at",
                is(POST_CREATED_AT)
        ));
    }

    @Test
    public void testUpdatedAt() throws Exception {
        this.response.andExpect(jsonPath(
                "$.updated_at",
                is(POST_UPDATED_AT)
        ));
    }

    private void mockPostManager() {
        Mockito.when(this.postManager.retrieve(Mockito.anyInt()))
                .thenReturn(this.post);
    }

    private void sendRequestToRetrieveSingle() throws Exception {
        this.response = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/posts/" + POST_ID)
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
