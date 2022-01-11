package com.dohatec.sharethoughts.service;

import com.dohatec.sharethoughts.model.Post;
import com.dohatec.sharethoughts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
