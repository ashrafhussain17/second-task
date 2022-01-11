package com.dohatec.sharethoughts.controller;

import com.dohatec.sharethoughts.model.Post;
import com.dohatec.sharethoughts.repository.PostRepository;
import com.dohatec.sharethoughts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.findAllPosts();
    }
}
