package com.boredblog.entity;

import com.boredblog.jsonview.AuthorJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
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
    @NotBlank(message = "{author.first_name.NotBlank}")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotBlank(message = "{author.last_name.NotBlank}")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;
    @OneToMany
    @OrderBy("created_at DESC")
    private List<Post> posts;

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

    @JsonView(AuthorJsonView.ShowAuthorDetail.class)
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @JsonView(AuthorJsonView.AuthorFullName.class)
    @JsonProperty("user")
    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    @Override
    public String toString() {
        return "Author{" +
                super.toString() +
                ", " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", posts=" + posts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Author author = (Author) o;

        if (!getFirstName().equals(author.getFirstName())) return false;
        if (!getLastName().equals(author.getLastName())) return false;
        if (!getPassword().equals(author.getPassword())) return false;
        return !(getPosts() != null ? !getPosts().equals(author.getPosts()) : author.getPosts() != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getPosts() != null ? getPosts().hashCode() : 0);
        return result;
    }
}
