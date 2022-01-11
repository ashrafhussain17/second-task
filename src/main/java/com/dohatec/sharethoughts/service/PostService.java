package com.dohatec.sharethoughts.service;

import com.dohatec.sharethoughts.model.Post;
import com.dohatec.sharethoughts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post createNewPost(Post post) {
        Post newPost = postRepository.save(post);
        return  newPost;
    }

    public Post findByUserWithId(int id) {
        Post post = postRepository.findByPostId(id);
        return post;
    }

    @Transactional
    public void deletePostById(int id) {
        postRepository.deleteByPostId(id);
    }
}
