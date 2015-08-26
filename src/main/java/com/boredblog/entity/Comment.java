package com.boredblog.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
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
    private String content;
    @ManyToOne
    private User user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    @JsonProperty("created_at")
    public Timestamp getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    @JsonProperty("updated_at")
    public Timestamp getUpdatedAt() {
        return super.getUpdatedAt();
    }
}
