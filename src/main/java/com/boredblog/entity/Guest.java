package com.boredblog.entity;

import javax.persistence.*;
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
    @Column(name = "screen_name", nullable = false)
    private String screenName;
    @OneToMany(mappedBy = "user")
    @OrderBy("created_at ASC")
    private List<Comment> comments;

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
