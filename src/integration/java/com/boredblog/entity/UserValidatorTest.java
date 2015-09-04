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
 * Validates that the Validator in the abstract class User is working.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PropertyPlaceholderConfig.class,
        JpaConfig.class
})
public class UserValidatorTest {
    private static Validator validator;

    @Value("${user.screen_name.NotBlank}")
    private String userScreenNameNotBlankMessage;

    @BeforeClass
    public static void beforeSetup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void authorScreenNameIsEmpty() {
        Author author = new Author();
        author.setFirstName("Johnny");
        author.setLastName("Nexient");
        author.setScreenName("");

        Set<ConstraintViolation<Author>> violations
                = validator.validate(author);

        assertEquals(1, violations.size());
        assertEquals(
                this.userScreenNameNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void authorScreenNameIsNull() {
        Author author = new Author();
        author.setFirstName("Johnny");
        author.setLastName("Nexient");
        author.setScreenName(null);

        Set<ConstraintViolation<Author>> violations
                = validator.validate(author);

        assertEquals(1, violations.size());
        assertEquals(
                this.userScreenNameNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void guestScreenNameIsEmpty() {
        Guest guest = new Guest();
        guest.setScreenName("");

        Set<ConstraintViolation<Guest>> violations
                = validator.validate(guest);

        assertEquals(1, violations.size());
        assertEquals(
                this.userScreenNameNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }

    @Test
    public void guestScreenNameIsNull() {
        Guest guest = new Guest();
        guest.setScreenName(null);

        Set<ConstraintViolation<Guest>> violations
                = validator.validate(guest);

        assertEquals(1, violations.size());
        assertEquals(
                this.userScreenNameNotBlankMessage,
                violations.iterator().next().getMessage()
        );
    }
}
