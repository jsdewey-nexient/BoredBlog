package com.boredblog.entity;

import com.boredblog.jsonview.AuthorJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/18/2015
 * Group: Joel
 * Describes a user of the blog. He/she may add posts and edit new ones.
 */
@Entity
@DiscriminatorValue("Author")
public class Author extends User {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;
    @JsonIgnore
    @OneToMany
    @OrderBy("created_at DESC")
    private List<Post> posts;

    @JsonView(AuthorJsonView.LimitedAuthor.class)
    public Integer getId() {
        return super.getId();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(AuthorJsonView.FullAuthor.class)
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @JsonView(AuthorJsonView.LimitedAuthor.class)
    @JsonProperty("user")
    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }
}
