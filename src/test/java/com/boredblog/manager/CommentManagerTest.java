package com.boredblog.manager;

import com.boredblog.repository.CommentRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author Joel Dewey
 * @date 8/24/2015
 * Group: Joel
 * Verify the behavior of the CommentManager.
 */
public class CommentManagerTest {
    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private CommentManager commentManager;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
