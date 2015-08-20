package com.boredblog.manager;

import com.boredblog.entity.Comment;
import com.boredblog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Handle Comment objects.
 */
@Service
public class CommentManager {
    @Autowired
    private CommentRepository commentRepository;

    public Comment create(Comment comment) {
        return this.commentRepository.save(comment);
    }

    public Comment retrieve(Integer id) {
        return this.commentRepository.findOne(id);
    }

    public Comment update(Comment comment) {
        return this.create(comment);
    }
}
