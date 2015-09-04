package com.boredblog.entity;

import com.boredblog.config.JpaConfig;
import com.boredblog.config.PropertyPlaceholderConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Joel Dewey
 * @date 9/4/2015
 * Group: Joel
 * Verify that the Hibernate Validator is working for the Post entity.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PropertyPlaceholderConfig.class,
        JpaConfig.class
})
public class PostValidatorTest {
}
