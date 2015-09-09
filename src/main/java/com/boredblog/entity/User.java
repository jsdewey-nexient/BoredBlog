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
    @NotBlank(message = "{user.screen_name.NotBlank}")
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

    @Override
    public String toString() {
        return super.toString() +
                "screenName='" + screenName + '\'' +
                ", comments=" + comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (!getScreenName().equals(user.getScreenName())) return false;
        return !(getComments() != null ? !getComments().equals(user.getComments()) : user.getComments() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getScreenName().hashCode();
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        return result;
    }
}
