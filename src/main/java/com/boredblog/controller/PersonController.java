package com.boredblog.controller;

import com.boredblog.enums.Gender;
import com.boredblog.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joel Dewey
 * @date 8/18/2015
 * Group: Joel
 * Responsible for delivering Person objects.
 */
@RestController
public class PersonController {

    @RequestMapping(name = "person", method = RequestMethod.GET)
    public Person read() {
        Person person = new Person();
        person.setAge(23);
        person.setPersonGender(Gender.MALE);

        return person;
    }
}
