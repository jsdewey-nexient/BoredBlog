package com.boredblog.entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Verify that the Guest entity works as it should.
 */
public class GuestTest extends BaseTimestampTest {
    public static final int ID = 1;
    private final String SCREEN_NAME = "knexient4";
    @Mock
    private List<Comment> comments;
    @InjectMocks
    private Guest guest;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.guest.setId(ID);
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

    @Test
    public void testEquals() {
        Guest firstGuest = this.setUnmockedProperties(new Guest());
        Guest secondGuest = this.setUnmockedProperties(new Guest());

        assertTrue(
                "testEquals did not receive equal Guest objects.",
                firstGuest.equals(secondGuest)
                        && secondGuest.equals(firstGuest)
        );
    }

    @Test
    public void testHashCode() {
        Guest firstGuest = this.setUnmockedProperties(new Guest());
        Guest secondGuest = this.setUnmockedProperties(new Guest());

        assertTrue(
                "testHashCode did not receive equal hash codes from the " +
                        "Guest objects.",
                firstGuest.hashCode() == secondGuest.hashCode()
        );
    }

    private Guest setUnmockedProperties(Guest guest) {
        guest.setId(ID);
        guest.setScreenName(SCREEN_NAME);
        guest.setCreatedAt(CREATED_AT);
        guest.setUpdatedAt(UPDATED_AT);

        return guest;
    }
}
