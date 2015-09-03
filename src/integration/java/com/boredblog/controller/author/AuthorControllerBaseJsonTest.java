package com.boredblog.controller.author;

import com.boredblog.controller.AuthorController;
import com.boredblog.controller.BaseJsonTest;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.entity.Post;
import com.boredblog.manager.AuthorManager;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joel Dewey
 * @date 9/1/2015
 * Group: Joel
 * A base class for the Author JSON tests to extend and share code.
 */
public class AuthorControllerBaseJsonTest extends BaseJsonTest {
    protected AuthorManager authorManager;
    // Anything being serialized should not be mocked.
    protected Author firstAuthor;
    protected List<Comment> comments;
    protected List<Post> posts;
    protected List<Author> authors;
    protected final int FIRST_AUTHOR_ID = 1;
    protected final String FIRST_AUTHOR_FIRST_NAME = "Johnny";
    protected final String FIRST_AUTHOR_LAST_NAME = "Nexient";
    protected final String FIRST_AUTHOR_PASSWORD = "Shouldn't see this!";
    protected final String FIRST_AUTHOR_SCREEN_NAME = "jnexient";

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
        post.setId(1);
        post.setCreatedAt(new Timestamp(130000000));
        post.setContent("When a single Author is requested, only the " +
                "title of his or her last five posts may be shown.");
        post.setTitle("Single Author Only");
        this.posts.add(post);
    }

    protected void addCommentsToList() {
        Comment comment = new Comment();
        comment.setContent("I should only be seen when a single Author " +
                "is requested.");
        comment.setId(1);
        comment.setCreatedAt(new Timestamp(123456789));
        this.comments.add(comment);
    }

    protected void addAuthorToList(Author author) {
        this.authors.add(author);
    }

    protected void setFirstAuthorProperties() {
        this.firstAuthor.setId(FIRST_AUTHOR_ID);
        this.firstAuthor.setFirstName(FIRST_AUTHOR_FIRST_NAME);
        this.firstAuthor.setLastName(FIRST_AUTHOR_LAST_NAME);
        this.firstAuthor.setScreenName(FIRST_AUTHOR_SCREEN_NAME);
        this.firstAuthor.setPassword(FIRST_AUTHOR_PASSWORD);
        this.firstAuthor.setCreatedAt(new Timestamp(1));
        this.firstAuthor.setUpdatedAt(new Timestamp(2));
        this.firstAuthor.setComments(this.comments);
        this.firstAuthor.setPosts(this.posts);
        addAuthorToList(this.firstAuthor);
    }
}
