package com.boredblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * An entity describing a Guest, who may only post comments.
 */
@Entity
@Table(name = "guests")
public class Guest extends BaseEntity {
    @Column(name = "screenname", nullable = false)
    private String screenname;

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }
}
