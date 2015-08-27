package com.boredblog.controller;

import com.boredblog.config.WebConfig;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.entity.Post;
import com.boredblog.manager.AuthorManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

/**
 * @author Joel Dewey
 * @date 8/27/2015
 * Group: Joel
 * Validates that the JSON responses are valid.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class })
public class AuthorControllerJsonTest {
    public static final int SIZE_OF_RESPONSEALL_ARRAY = 2;
    @Mock
    private AuthorManager authorManager;
    @InjectMocks
    private AuthorController authorController;
    // Anything being serialized should not be mocked.
    private Author firstAuthor;
    private Author secondAuthor;
    private List<Comment> comments;
    private List<Post> posts;
    private List<Author> authors;

    @Autowired
    private MappingJackson2HttpMessageConverter jackson2HttpMessageConverter;
    private MockMvc mockMvc;
    private ResultActions responseAll;
    private ResultActions responseSingle;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        instantiateDependentObjects();
        buildMockMvc();
        addPostsToList();
        addCommentsToList();
        setFirstAuthorProperties();
        setSecondAuthorProperties();
        mockAuthorManager();
        sendRequestToRetrieveAll();
        sendRequestToRetrieveSingleAuthor();
    }

    private void instantiateDependentObjects() {
        this.firstAuthor = new Author();
        this.secondAuthor = new Author();
        this.comments = new ArrayList<Comment>();
        this.posts = new ArrayList<Post>();
        this.authors = new ArrayList<Author>();
    }

    @Test
    public void testSuccessfulResponseAll() throws Exception{
        final MvcResult result = this.responseAll
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentType("application/json;charset=UTF-8"))
                .andReturn();
        System.out.println(
                "JSON String: "
                        + result.getResponse().getContentAsString()
        );
    }

    @Test
    public void testResponseAllCorrectLength() throws Exception {
        this.responseAll
                .andExpect(
                        MockMvcResultMatchers.jsonPath(
                                "$.*",
                                hasSize(SIZE_OF_RESPONSEALL_ARRAY)
                        )
                );
    }

    @Test
    public void testResponseAllId() throws Exception {
        this.responseAll
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id", is(2)));
    }

    @Test
    public void testResponseAllScreenName() throws Exception {
        this.responseAll
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].screen_name", is("jnexient")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].screen_name", is("Codehaus")));
    }

    @Test
    public void testResponseAllFirstName() throws Exception {
        this.responseAll
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].first_name", is("Johnny")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].first_name", is("Jackson")));
    }

    private void buildMockMvc() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.authorController)
                .setMessageConverters(this.jackson2HttpMessageConverter)
                .build();
    }

    private void addPostsToList() {
        Post post = new Post();
        post.setContent("When a single Author is requested, only the " +
                "title of his or her last five posts may be shown.");
        for(int i = 0; i < 5; i++) {
            post.setTitle("Single Author Only: " + i);
            this.posts.add(post);
        }
    }

    private void addCommentsToList() {
        Comment comment = new Comment();
        comment.setContent("I should only be seen when a single Author " +
                "is requested.");
        for(int i = 0; i < 5; i++) {
            this.comments.add(comment);
        }
    }

    private void setFirstAuthorProperties() {
        this.firstAuthor.setId(1);
        this.firstAuthor.setFirstName("Johnny");
        this.firstAuthor.setLastName("Nexient");
        this.firstAuthor.setScreenName("jnexient");
        this.firstAuthor.setPassword("Shouldn't see this!");
        this.firstAuthor.setCreatedAt(new Timestamp(1));
        this.firstAuthor.setUpdatedAt(new Timestamp(2));
        this.firstAuthor.setComments(this.comments);
        this.firstAuthor.setPosts(this.posts);
        addAuthorToList(this.firstAuthor);
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

    private void addAuthorToList(Author author) {
        this.authors.add(author);
    }

    private void mockAuthorManager() {
        Mockito.when(this.authorManager.retrieveAll()).thenReturn(this.authors);
        Mockito.when(this.authorManager.retrieve(1)).thenReturn(this.firstAuthor);
    }

    private void sendRequestToRetrieveAll() throws Exception {
        this.responseAll = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/authors")
                        .accept(MediaType.APPLICATION_JSON)
        );
    }

    private void sendRequestToRetrieveSingleAuthor() throws Exception {
        this.responseSingle = this.mockMvc.perform(
                MockMvcRequestBuilders.get("/authors/1")
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
