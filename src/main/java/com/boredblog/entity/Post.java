package com.boredblog.entity;

import com.boredblog.jsonview.PostJsonView;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Describes a blog post made by the author.
 */
@Entity
@Table(name = "posts")
public class Post extends BaseEntity {
    @NotBlank(message = "{post.title.NotBlank}")
    @Column(name = "title", nullable = false)
    private String title;
    @NotBlank(message = "{post.content.NotBlank}")
    @Column(name = "content", nullable = false)
    private String content;
    @OneToMany
    private List<Comment> comments;
    @ManyToOne
    private Author author;

    @JsonView(PostJsonView.ListPosts.class)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonView(PostJsonView.ShowPostDetail.class)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonView(PostJsonView.ListPosts.class)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    @JsonProperty("created_at")
    @JsonView(PostJsonView.ListPosts.class)
    public Timestamp getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    @JsonProperty("updated_at")
    @JsonView(PostJsonView.ListPosts.class)
    public Timestamp getUpdatedAt() {
        return super.getUpdatedAt();
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Post post = (Post) o;

        if (!getTitle().equals(post.getTitle())) return false;
        if (!getContent().equals(post.getContent())) return false;
        if (getComments() != null ? !getComments().equals(post.getComments()) : post.getComments() != null)
            return false;
        return getAuthor().equals(post.getAuthor());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        return result;
    }
}
