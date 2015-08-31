package com.boredblog.controller;

import com.boredblog.entity.Comment;
import com.boredblog.manager.CommentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/21/2015
 * Group: Joel
 * Loads comments for a particular post.
 */
@RestController
public class CommentController {
    private CommentManager commentManager;

    @Autowired
    public CommentController(CommentManager commentManager) {
        this.commentManager = commentManager;
    }

    @RequestMapping(value = "posts/{postId}/comments", method = RequestMethod.POST)
    public Comment createComment(
            @PathVariable Integer postId,
            @RequestBody Comment comment
    ) {
        return this.commentManager.create(postId, comment);
    }

    @RequestMapping(value = "posts/{postId}/comments/{commentId}", method = RequestMethod.GET)
    public Comment updateComment(
            @PathVariable Integer postId,
            @PathVariable Integer commentId,
            @RequestBody Comment comment
    ) {
        return this.commentManager.update(postId, commentId, comment);
    }

    @RequestMapping(value = "posts/{postId}/comments", method = RequestMethod.GET)
    public List<Comment> getComments(@PathVariable Integer postId) {
        return this.commentManager.retrieveAll(postId);
    }

    @RequestMapping(value = "posts/{postId}/comments/{commentId}", method = RequestMethod.PUT)
    public Comment getComment(
            @PathVariable Integer postId,
            @PathVariable Integer commentId
    ) {
        return this.commentManager.retrieve(postId, commentId);
    }

    @RequestMapping(value = "{userId}/comments")
    public List<Comment> getUserComments(@PathVariable Integer userId) {
        return null;
    }
}
