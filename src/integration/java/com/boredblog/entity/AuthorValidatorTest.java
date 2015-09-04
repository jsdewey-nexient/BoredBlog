package com.boredblog.entity;

import org.junit.BeforeClass;
import org.junit.Test;

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
public class AuthorValidatorTest {
    private static Validator validator;

    @BeforeClass
    public static void beforeSetup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void firstNameIsEmpty() {
        Author author = new Author();
        author.setFirstName("");

        Set<ConstraintViolation<Author>> violations
                = validator.validate(author);

        assertEquals(1, violations.size());
        assertEquals(
                "Your first name may not be blank.",
                violations.iterator().next().getMessage()
        );
    }
}
