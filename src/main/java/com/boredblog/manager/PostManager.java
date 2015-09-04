package com.boredblog.manager;

import com.boredblog.entity.Post;
import com.boredblog.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${post_fields}")
    private String ignoredFields[];

    public Post create(Post post) {
        return this.postRepository.save(post);
    }

    public Post retrieve(Integer id) {
        return this.postRepository.findOne(id);
    }

    public List<Post> retrieveAll() {
        return this.postRepository.findAll();
    }

    public Post update(Integer id, Post post) {
        Post existingPost = this.retrieve(id);
        BeanUtils.copyProperties(post, existingPost, this.ignoredFields);
        return this.postRepository.save(existingPost);
    }
}
