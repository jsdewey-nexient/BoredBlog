package com.boredblog.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * A base entity for Authors and Guests.
 */
@Entity
@Inheritance
@Table(name = "users")
public abstract class User extends BaseEntity {
    @OneToMany(mappedBy = "user")
    @OrderBy("created_at ASC")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
