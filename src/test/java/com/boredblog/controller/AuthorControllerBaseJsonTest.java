package com.boredblog.controller;

import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.entity.Post;
import com.boredblog.manager.AuthorManager;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joel Dewey
 * @date 9/1/2015
 * Group: Joel
 * A base class for the Author JSON tests to extend and share code.
 */
public class AuthorControllerBaseJsonTest {
    public static final int SIZE_OF_JSON_OBJECT = 4;
    protected AuthorManager authorManager;
    // Anything being serialized should not be mocked.
    protected Author firstAuthor;
    protected List<Comment> comments;
    protected List<Post> posts;
    protected List<Author> authors;

    protected void instantiateDependentObjects() {
        this.authorManager = Mockito.mock(AuthorManager.class);
        this.firstAuthor = new Author();
        this.comments = new ArrayList<Comment>();
        this.posts = new ArrayList<Post>();
        this.authors = new ArrayList<Author>();
    }
}
