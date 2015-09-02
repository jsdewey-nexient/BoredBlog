package com.boredblog.entity;

import com.boredblog.jsonview.AuthorJsonView;
import com.boredblog.jsonview.PostJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

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
    @Column(name = "title", nullable = false)
    private String title;
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
}
