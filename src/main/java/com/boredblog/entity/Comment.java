package com.boredblog.entity;

import com.boredblog.jsonview.AuthorJsonView;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

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

    public String getContent() {
        return content;
    }

    @JsonView(AuthorJsonView.FullAuthor.class)
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    @JsonProperty("created_at")
    @JsonView(AuthorJsonView.FullAuthor.class)
    public Timestamp getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    @JsonProperty("updated_at")
    @JsonView(AuthorJsonView.FullAuthor.class)
    public Timestamp getUpdatedAt() {
        return super.getUpdatedAt();
    }
}
