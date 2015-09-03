package com.boredblog.entity;

import com.boredblog.jsonview.CommentJsonView;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Describes a Comment, which can be written by either a Guest or a Author.
 */
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    @Column(name = "content", nullable = false)
    @NotBlank
    private String content;
    @ManyToOne
    private User user;

    @JsonView(CommentJsonView.ShowCommentDetail.class)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonView(CommentJsonView.ShowCommentDetail.class)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    @JsonProperty("created_at")
    @JsonView(CommentJsonView.ShowCommentDetail.class)
    public Timestamp getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    @JsonProperty("updated_at")
    @JsonView(CommentJsonView.ShowCommentDetail.class)
    public Timestamp getUpdatedAt() {
        return super.getUpdatedAt();
    }
}
