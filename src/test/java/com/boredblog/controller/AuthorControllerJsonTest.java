package com.boredblog.controller;

import com.boredblog.config.WebConfig;
import com.boredblog.entity.Author;
import com.boredblog.entity.Comment;
import com.boredblog.manager.AuthorManager;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/27/2015
 * Group: Joel
 * Validates that the JSON responses are valid.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class })
public class AuthorControllerJsonTest {
    @Mock
    private AuthorManager authorManager;
    @InjectMocks
    private AuthorController authorController;
    private Author author;
    private List<Comment> comments;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}
