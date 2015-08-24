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
        this.createDependentObjects();
        this.setDependentObjectProperties();
        this.mockGuestRepository();
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
        String originalScreenName = this.guest.getScreenName();
        String updatedScreenName = null;
        this.guestManager.update(GUEST_ID, this.updatedGuest);
        updatedScreenName = this.guest.getScreenName();

        assertNotEquals(
                "testUpdatingGuest received a null string back.",
                null,
                updatedScreenName
        );

        assertNotEquals(
                "testUpdatingGuest receive the same screen name back.",
                originalScreenName,
                updatedScreenName
        );
    }

    private void mockGuestRepository() {
        Mockito.when(this.guestRepository.findOne(GUEST_ID))
                .thenReturn(this.guest);
        Mockito.when(this.guestRepository.save(this.guest))
                .thenReturn(this.guest);
    }

    private void createDependentObjects() {
        this.guest = new Guest();
        this.updatedGuest = new Guest();
    }

    private void setDependentObjectProperties() {
        this.guest.setScreenName("Johnny");
        this.updatedGuest.setScreenName("Johnson");
    }
}
