package com.boredblog.manager;

import com.boredblog.repository.GuestRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Joel Dewey
 * @date 8/24/2015
 * Group: Joel
 * Verify the correct behavior of the GuestManager.
 */
public class GuestManagerTest {
    @Mock
    private GuestRepository guestRepository;
    @InjectMocks
    private GuestManager guestManager;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
