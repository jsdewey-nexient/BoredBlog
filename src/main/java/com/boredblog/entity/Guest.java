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
@Table(name = "guests")
public class Guest extends User {
    @Column(name = "screenname", nullable = false)
    private String screenname;
    @OneToMany(mappedBy = "user")
    @OrderBy("created_at ASC")
    private List<Comment> comments;

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
