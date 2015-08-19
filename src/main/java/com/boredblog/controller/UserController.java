package com.boredblog.controller;

import com.boredblog.entity.User;
import com.boredblog.enums.Gender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joel Dewey
 * @date 8/18/2015
 * Group: Joel
 * Responsible for delivering User objects.
 */
@RestController
public class UserController {

    @RequestMapping(name = "person", method = RequestMethod.GET)
    public User read() {
        User user = new User();
        user.setAge(23);
        user.setPersonGender(Gender.MALE);

        return user;
    }
}
