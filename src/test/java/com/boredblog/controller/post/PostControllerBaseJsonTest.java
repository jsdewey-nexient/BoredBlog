package com.boredblog.controller.post;

import com.boredblog.controller.BaseJsonTest;
import com.boredblog.controller.PostController;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.entity.Post;
import com.boredblog.manager.PostManager;

import java.sql.Timestamp;

/**
 * @author Joel Dewey
 * @date 9/2/2015
 * Group: Joel
 * A class containing shared methods.
 */
public class PostControllerBaseJsonTest extends BaseJsonTest {
    public static final int AUTHOR_ID = 1;
    public static final String AUTHOR_FIRST_NAME = "Johnny";
    public static final String AUTHOR_LAST_NAME = "Nexient";
    public static final String AUTHOR_SCREEN_NAME = "jnexient";
    public static final int COMMENT_ID = 1;
    public static final String COMMENT_CONTENT = "Hello!";
    public static final Timestamp COMMENT_CREATED_AT = new Timestamp(13500000);
    public static final int POST_ID = 1;
    public static final String POST_TITLE = "The title that should be seen.";
    public static final String POST_CONTENT = "The content that should be seen.";
    public static final int POST_CREATED_AT = 13000000;
    public static final int POST_UPDATED_AT = 14000000;
    public static final int LENGTH_OF_ARRAY = 5;
    public static final int SIZE_OF_AUTHOR_OBJECT = 2;
    public PostController postController;
    public PostManager postManager;
    public Post post;
    public Author author;
    public Comment comment;
}
