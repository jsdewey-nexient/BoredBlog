package com.boredblog.controller;

import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.entity.Post;
import com.boredblog.manager.AuthorManager;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Joel Dewey
 * @date 9/1/2015
 * Group: Joel
 * A base class for the Author JSON tests to extend and share code.
 */
public class AuthorControllerBaseJsonTest {
    protected AuthorManager authorManager;
    // Anything being serialized should not be mocked.
    protected Author firstAuthor;
    protected List<Comment> comments;
    protected List<Post> posts;
    protected List<Author> authors;

    @Autowired
    private MappingJackson2HttpMessageConverter jackson2HttpMessageConverter;
    protected MockMvc mockMvc;
    protected ResultActions response;

    protected void instantiateDependentObjects() {
        this.authorManager = Mockito.mock(AuthorManager.class);
        this.firstAuthor = new Author();
        this.comments = new ArrayList<Comment>();
        this.posts = new ArrayList<Post>();
        this.authors = new ArrayList<Author>();
    }

    protected void buildMockMvc() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AuthorController(this.authorManager))
                .setMessageConverters(this.jackson2HttpMessageConverter)
                .build();
    }

    protected void mockAuthorManager() {
        Mockito.when(this.authorManager.retrieveAll()).thenReturn(this.authors);
        Mockito.when(this.authorManager.retrieve(Matchers.anyInt())).thenReturn(this.firstAuthor);
    }

    protected void addPostsToList() {
        Post post = new Post();
        post.setContent("When a single Author is requested, only the " +
                "title of his or her last five posts may be shown.");
        for(int i = 0; i < 5; i++) {
            post.setTitle("Single Author Only: " + i);
            this.posts.add(post);
        }
    }

    protected void addCommentsToList() {
        Comment comment = new Comment();
        comment.setContent("I should only be seen when a single Author " +
                "is requested.");
        for(int i = 0; i < 5; i++) {
            this.comments.add(comment);
        }
    }

    protected void addAuthorToList(Author author) {
        this.authors.add(author);
    }

    protected void setFirstAuthorProperties() {
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

    protected void testSuccessfulRequest(ResultActions response)
            throws Exception {
        final MvcResult result = response
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
        System.out.println(
                "JSON String: "
                        + result.getResponse().getContentAsString()
        );
    }
}
