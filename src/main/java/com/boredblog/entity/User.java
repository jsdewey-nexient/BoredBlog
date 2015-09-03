package com.boredblog.entity;

import com.boredblog.jsonview.AuthorJsonView;
import com.boredblog.jsonview.UserJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

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
    @NotBlank
    @Column(name = "screen_name", nullable = false)
    private String screenName;
    @OneToMany
    @OrderBy("created_at ASC")
    private List<Comment> comments;

    @JsonView(UserJsonView.UserScreenName.class)
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @JsonView(AuthorJsonView.ShowAuthorDetail.class)
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
