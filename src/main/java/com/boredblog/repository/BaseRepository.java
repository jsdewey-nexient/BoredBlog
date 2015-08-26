package com.boredblog.repository;

import com.boredblog.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * @author Joel Dewey
 * @date 8/26/2015
 * Group: Joel
 * A base repository for all other repositories to extend.
 */
public interface BaseRepository<T extends BaseEntity, ID extends Serializable>
    extends JpaRepository<T, ID> {
}
