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
 * Verify that the Hibernate Validator is working for the Comment entity.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PropertyPlaceholderConfig.class,
        JpaConfig.class
})
public class CommentValidatorTest {
    private static Validator validator;

    @Value("${comment.content.NotBlank}")
    private String commentContentNotBlankMessage;

    @BeforeClass
    public static void beforeSetup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void contentIsNull() {
        Comment comment = new Comment();
        comment.setContent(null);

        Set<ConstraintViolation<Comment>> violations
                = validator.validate(comment);

        assertEquals(1, violations.size());
        assertEquals(
                this.commentContentNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void contentIsEmpty() {
        Comment comment = new Comment();
        comment.setContent("");

        Set<ConstraintViolation<Comment>> violations
                = validator.validate(comment);

        assertEquals(1, violations.size());
        assertEquals(
                this.commentContentNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }
}
