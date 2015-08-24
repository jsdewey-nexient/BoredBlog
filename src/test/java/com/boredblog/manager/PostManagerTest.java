package com.boredblog.manager;

import com.boredblog.repository.PostRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author Joel Dewey
 * @date 8/24/2015
 * Group: Joel
 * Verify that the PostManager is working correctly.
 */
public class PostManagerTest {
    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private PostManager postManager;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
