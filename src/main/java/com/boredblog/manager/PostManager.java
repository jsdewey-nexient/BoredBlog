package com.boredblog.manager;

import com.boredblog.entity.Post;
import com.boredblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Joel Dewey
 * @date 8/20/2015
 * Group: Joel
 * Handles Post objects.
 */
@Service
public class PostManager {
    @Autowired
    private PostRepository postRepository;

    public Post create(Post post) {
        return this.postRepository.save(post);
    }

    public Post retrieve(Integer id) {
        return this.postRepository.findOne(id);
    }

    public List<Post> retrieveAll() {
        return this.postRepository.findAll();
    }

    public Post update(Post post) {
        return this.create(post);
    }
}
