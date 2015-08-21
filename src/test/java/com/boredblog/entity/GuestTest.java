package com.boredblog.entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that the Guest entity works as it should.
 */
public class GuestTest {
    private final String SCREEN_NAME = "knexient4";
    @Mock
    private List<Comment> comments;
    @InjectMocks
    private Guest guest;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.guest.setScreenName(SCREEN_NAME);
    }

    @Test
    public void testCommentsMatches() {
        List<Comment> result = this.guest.getComments();

        assertEquals(
                "testCommentsMatches did not receive mocked Comment List " +
                        "object back.",
                this.comments,
                result
        );
    }

    @Test
    public void testScreenNameMatches() {
        String result = this.guest.getScreenName();

        assertEquals(
                "testScreenNameMatches did not receive expected screen name.",
                SCREEN_NAME,
                result
        );
    }
}
