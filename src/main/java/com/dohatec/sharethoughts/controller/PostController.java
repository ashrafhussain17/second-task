package com.dohatec.sharethoughts.controller;

import com.dohatec.sharethoughts.exception.PostNotCreated;
import com.dohatec.sharethoughts.exception.PostNotFoundException;
import com.dohatec.sharethoughts.exception.UserNotFoundException;
import com.dohatec.sharethoughts.model.Post;
import com.dohatec.sharethoughts.service.PostService;
import com.dohatec.sharethoughts.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        logger.info("Fetching all the posts");
        List<Post> posts = postService.findAllPosts();
        if (posts.size() <= 0){
            throw new PostNotFoundException();
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@Valid  @RequestBody Post post){
        logger.info("Creating a new post");
        Post post1 = postService.createNewPost(post);
        return  new ResponseEntity<>(post1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getUserById(@PathVariable int id){
        logger.info("Getting a post based on the provided Id");
        Post post = postService.findByUserWithId(id);
        if(post == null){
            throw new PostNotFoundException();
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePostsWithId(@PathVariable int id) {
        logger.info("Deleting a post");
        postService.deletePostById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Post>> getPostsForUsers(@PathVariable int userId){
        logger.info("Getting all the posts of a user");
        if(userService.findByUserWithId(userId) == null){
            throw new UserNotFoundException();
        }
        List<Post> posts = postService.findAllPostsForASpecificUser(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
