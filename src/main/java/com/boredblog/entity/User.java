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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "users")
@DiscriminatorColumn(
        name = "discriminator",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class User extends BaseEntity {
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
