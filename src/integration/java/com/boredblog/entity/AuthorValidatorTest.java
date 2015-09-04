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
 * Validate that the Hibernate Validator is acting accordingly.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PropertyPlaceholderConfig.class,
        JpaConfig.class
})
public class AuthorValidatorTest {
    private static Validator validator;

    @Value("${author.first_name.NotBlank}")
    private String authorFirstNameNotBlankMessage;

    @BeforeClass
    public static void beforeSetup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void firstNameIsEmpty() {
        Author author = new Author();
        author.setFirstName("");
        author.setLastName("Nexient");
        author.setScreenName("jnexient");

        Set<ConstraintViolation<Author>> violations
                = validator.validate(author);

        assertEquals(1, violations.size());
        assertEquals(
                this.authorFirstNameNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void firstNameIsNull() {
        Author author = new Author();
        author.setFirstName(null);
        author.setLastName("Nexient");
        author.setScreenName("jnexient");

        Set<ConstraintViolation<Author>> violations
                = validator.validate(author);

        assertEquals(1, violations.size());
        assertEquals(
                this.authorFirstNameNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }
}
