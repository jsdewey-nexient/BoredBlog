package com.boredblog.manager;

import com.boredblog.entity.Comment;
import com.boredblog.repository.CommentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Value("${comment_fields}")
    private String ignoredFields[];

    public Comment create(Integer postId, Comment comment) {
        return this.commentRepository.save(comment);
    }

    /**
     * @todo This should fail if the postId != comment.post_id.
     */
    public Comment retrieve(Integer postId, Integer commentId) {
        return this.commentRepository.findOne(commentId);
    }

    public List<Comment> retrieveAll(Integer postId) {
        return this.commentRepository.findAll();
    }

    public Comment update(Integer postId, Integer commentId, Comment comment) {
        Comment existingComment = this.retrieve(postId, commentId);
        BeanUtils.copyProperties(comment, existingComment, this.ignoredFields);
        return this.commentRepository.save(comment);
    }
}
