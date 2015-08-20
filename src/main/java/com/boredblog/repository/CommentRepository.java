package com.boredblog.repository;

import com.boredblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Responsible for handling Comments.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
