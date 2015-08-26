package com.boredblog.repository;

import com.boredblog.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author Joel Dewey
 * @date 8/26/2015
 * Group: Joel
 * A base repository for all other repositories to extend.
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable>
    extends JpaRepository<T, ID> {
}
