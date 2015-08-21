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
@RequestMapping("posts/{postId}/comments")
public class CommentController {
    @Autowired
    private CommentManager commentManager;

    @RequestMapping(method = RequestMethod.POST)
    public Comment createComment(
            @PathVariable Integer postId,
            @RequestBody Comment comment
    ) {
        return null;
    }

    @RequestMapping(value = "{commentId}", method = RequestMethod.GET)
    public Comment updateComment(
            @PathVariable Integer postId,
            @PathVariable Integer commentId,
            @RequestBody Comment comment
    ) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> getComments(@PathVariable Integer postId) {
        return null;
    }

    @RequestMapping(value = "{commentId}", method = RequestMethod.PUT)
    public Comment getComment(
            @PathVariable Integer postId,
            @PathVariable Integer commentId
    ) {
        return null;
    }
}
