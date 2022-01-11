package com.dohatec.sharethoughts.controller;

import com.dohatec.sharethoughts.exception.PostNotFoundException;
import com.dohatec.sharethoughts.model.Post;
import com.dohatec.sharethoughts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postService.findAllPosts(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        Post post1 = postService.createNewPost(post);
        return  new ResponseEntity<>(post1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getUserById(@PathVariable int id){
        Post post = postService.findByUserWithId(id);
        if(post == null){
            throw new PostNotFoundException();
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePostsWithId(@PathVariable int id) {
        postService.deletePostById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
