package com.boredblog.controller;

import org.mockito.Mockito;
import org.springframework.validation.BindingResult;

/**
 * @author Joel Dewey
 * @date 9/3/2015
 * Group: Joel
 * An abstract class with some shared properties.
 */
public abstract class BaseControllerTest {
    protected BindingResult bindingResult;

    public BaseControllerTest() {
        this.bindingResult = Mockito.mock(BindingResult.class);
        this.mockBindingResult();
    }

    private void mockBindingResult() {
        Mockito.when(this.bindingResult.hasErrors()).thenReturn(false);
    }
}
