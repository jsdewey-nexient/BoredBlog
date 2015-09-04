package com.boredblog.entity;

import org.junit.BeforeClass;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
}
