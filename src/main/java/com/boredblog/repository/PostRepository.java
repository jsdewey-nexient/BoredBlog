package com.boredblog.repository;

import com.boredblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Responsible for handling Posts.
 */
public interface PostRepository extends JpaRepository<Post, Integer> {
}
