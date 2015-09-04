package com.boredblog.entity;

import com.boredblog.config.JpaConfig;
import com.boredblog.config.PropertyPlaceholderConfig;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
    private static Validator validator;

    @Value("${post.title.NotBlank}")
    private String postTitleNotBlankMessage;
    @Value("${post.content.NotBlank}")
    private String postContentNotBlankMessage;

    @BeforeClass
    public static void beforeSetup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
}
