package com.boredblog.manager;

import com.boredblog.entity.Guest;
import com.boredblog.repository.GuestRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockGuestRepository();
    }



    @Test
    public void testCreateGuest() {

    }

    @Test
    public void testRetrievingSingleGuest() {

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
}
