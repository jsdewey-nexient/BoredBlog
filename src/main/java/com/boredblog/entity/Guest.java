package com.boredblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * An entity describing a Guest, who may only post comments.
 */
@Entity
@Table(name = "users")
@DiscriminatorValue("Guest")
public class Guest extends User {
}
