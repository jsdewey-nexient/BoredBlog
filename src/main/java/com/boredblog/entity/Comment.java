package com.boredblog.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Describes a Comment, which can be left by either a Guest or a User.
 */
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    @Column(name = "content", nullable = false)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
