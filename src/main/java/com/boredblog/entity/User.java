package com.boredblog.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * A base entity for Authors and Guests.
 */
@Entity
@Inheritance
public abstract class User extends BaseEntity {
}
