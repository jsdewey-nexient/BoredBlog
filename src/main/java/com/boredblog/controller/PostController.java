package com.boredblog.controller;

import com.boredblog.entity.Post;
import com.boredblog.manager.PostManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Responsible for the delivery of posts.
 */
@RestController
@RequestMapping("posts")
public class PostController {
    @Autowired
    private PostManager postManager;

    @RequestMapping(method = RequestMethod.GET)
    public function getPosts() {

    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public function getPost(@PathVariable Integer id) {

    }

    @RequestMapping(method = RequestMethod.POST)
    public function createPost() {

    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public function updatePost(
            @PathVariable Integer id,
            @RequestBody Post post
    ) {

    }
}
