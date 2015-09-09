package com.boredblog.entity;

import com.boredblog.jsonview.BaseJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * A base entity containing shared properties for all other entities to inherit
 * from.
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @JsonIgnore
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @JsonIgnore
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;

    @JsonView(BaseJsonView.class)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt + ", ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        if (!getId().equals(that.getId())) return false;
        if (!getCreatedAt().equals(that.getCreatedAt())) return false;
        return !(getUpdatedAt() != null ? !getUpdatedAt().equals(that.getUpdatedAt()) : that.getUpdatedAt() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCreatedAt() != null ? getCreatedAt().hashCode() : 0);
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        return result;
    }
}
