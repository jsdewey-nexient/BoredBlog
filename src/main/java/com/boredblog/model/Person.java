package com.boredblog.model;

import com.boredblog.enums.Gender;

/**
 * @author Joel Dewey
 * @date 8/18/2015
 * Group: Joel
 * Describes a person in terms of age and personGender.
 */
public class Person {
    private int age;
    private Gender personGender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getPersonGender() {
        return personGender;
    }

    public void setPersonGender(Gender personGender) {
        this.personGender = personGender;
    }
}
