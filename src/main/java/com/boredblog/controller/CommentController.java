package com.boredblog.controller;

import com.boredblog.entity.Comment;
import com.boredblog.manager.CommentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Loads comments for a particular post.
 */
@RestController
@RequestMapping("posts/{postId}/comments")
public class CommentController {
    @Autowired
    private CommentManager commentManager;

    public Comment createComment(Integer postId, Comment comment) {
        return null;
    }

    public Comment updateComment(Integer postId, Integer commentId, Comment comment) {
        return null;
    }

    public List<Comment> getComments(Integer postId) {
        return null;
    }

    public Comment getComment(Integer postId, Integer commentId) {
        return null;
    }
}
