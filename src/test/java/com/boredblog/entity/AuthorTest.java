package com.boredblog.entity;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that the Author entity works as expected.
 */
public class AuthorTest {
    private final String FIRST_NAME = "Johnny";
    private final String LAST_NAME = "Nexient";
    private final String SCREEN_NAME = "jNexient2";
    private final String PASS = "$2a$12$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyG" +
            "PBr08PpIi0na624b8.";
    @Mock
    private List<Post> posts;
    @Mock
    private List<Comment> comments;
    @InjectMocks
    private Author author;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

        this.setUnmockedFields();
    }

    private void setUnmockedFields() {
        author.setId(1);
        author.setFirstName(FIRST_NAME);
        author.setLastName(LAST_NAME);
        author.setScreenName(SCREEN_NAME);
        author.setPassword(PASS);
    }
}
