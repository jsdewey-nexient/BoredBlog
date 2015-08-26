package com.boredblog.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.OrderBy;
import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * A base entity for Authors and Guests.
 */
@Entity
@Inheritance
public abstract class User extends BaseEntity {
    @OrderBy("created_at ASC")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
