package com.boredblog.model;

import com.boredblog.enums.Gender;

/**
 * @author Joel Dewey
 * @date 8/18/2015
 * Group: Joel
 * Describes a person in terms of age and gender.
 */
public class Person {
    private int age;
    private Gender gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
