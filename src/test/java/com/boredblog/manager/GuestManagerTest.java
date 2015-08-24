package com.boredblog.manager;

import com.boredblog.entity.Guest;
import com.boredblog.repository.GuestRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * @author Joel Dewey
 * @date 8/24/2015
 * Group: Joel
 * Verify the correct behavior of the GuestManager.
 */
public class GuestManagerTest {
    private final Integer GUEST_ID = 1;
    @Mock
    private GuestRepository guestRepository;
    @InjectMocks
    private GuestManager guestManager;
    private Guest guest;
    private Guest updatedGuest;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockGuestRepository();
        this.setDependentObjectProperties();
    }

    @Test
    public void testCreateGuest() {
        Guest result = this.guestManager.create(this.guest);

        assertEquals(
                "testCreateGuest did not receive the expected Guest object.",
                this.guest,
                result
        );
    }

    @Test
    public void testRetrievingSingleGuest() {
        Guest result = this.guestManager.retrieve(GUEST_ID);

        assertEquals(
                "testRetrievingSingleGuest did not receive expected Guest " +
                        "object.",
                this.guest,
                result
        );
    }

    @Test
    public void testUpdatingGuest() {

    }

    private void mockGuestRepository() {
        Mockito.when(this.guestRepository.findOne(GUEST_ID))
                .thenReturn(this.guest);
        Mockito.when(this.guestRepository.save(this.guest))
                .thenReturn(this.guest);
    }

    private void setDependentObjectProperties() {
        this.guest.setScreenName("Johnny");
        this.updatedGuest.setScreenName("Johnson");
    }
}
