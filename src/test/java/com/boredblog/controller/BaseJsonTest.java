package com.boredblog.controller;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Joel Dewey
 * @date 9/2/2015
 * Group: Joel
 * A basic test class for the others to extend.
 */
public abstract class BaseJsonTest {
    protected void printJsonString(ResultActions response, String endpoint)
            throws Exception{
        final MvcResult result = response.andReturn();
        System.out.println(
                endpoint
                        + " JSON String: "
                        + result.getResponse().getContentAsString()
        );
    }

    protected void testSuccessfulRequest(ResultActions response)
            throws Exception {
        response.andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
}
