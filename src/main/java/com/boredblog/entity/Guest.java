package com.boredblog.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * An entity describing a Guest, who may only post comments.
 */
@Entity
@DiscriminatorValue("Guest")
public class Guest extends User {
    @Override
    public String toString() {
        return "Guest{" + super.toString() + "}";
    }
}
