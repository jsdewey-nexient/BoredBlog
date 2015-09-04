package com.boredblog.entity;

import com.boredblog.config.JpaConfig;
import com.boredblog.config.PropertyPlaceholderConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void titleIsEmpty() {
        Post post = new Post();
        post.setTitle("");
        post.setContent("This is content.");

        Set<ConstraintViolation<Post>> violations
                = validator.validate(post);

        assertEquals(1, violations.size());
        assertEquals(
                this.postTitleNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void titleIsNull() {
        Post post = new Post();
        post.setTitle(null);
        post.setContent("This is content.");

        Set<ConstraintViolation<Post>> violations
                = validator.validate(post);

        assertEquals(1, violations.size());
        assertEquals(
                this.postTitleNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void contentIsEmpty() {
        Post post = new Post();
        post.setTitle("This is a title.");
        post.setContent("");

        Set<ConstraintViolation<Post>> violations
                = validator.validate(post);

        assertEquals(1, violations.size());
        assertEquals(
                this.postContentNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void contentIsNull() {
        Post post = new Post();
        post.setTitle("This is a title.");
        post.setContent(null);

        Set<ConstraintViolation<Post>> violations
                = validator.validate(post);

        assertEquals(1, violations.size());
        assertEquals(
                this.postContentNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }
}
