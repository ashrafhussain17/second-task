package com.dohatec.sharethoughts.service;

import com.dohatec.sharethoughts.exception.PostNotFoundException;
import com.dohatec.sharethoughts.model.Post;
import com.dohatec.sharethoughts.model.User;
import com.dohatec.sharethoughts.repository.PostRepository;
import com.dohatec.sharethoughts.repository.UserRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post createNewPost(Post post) {
        return postRepository.save(post);
    }

    public Post findByUserWithId(int id) {
        Post post = postRepository.findByPostId(id);
        return post;
    }

    @Transactional
    public void deletePostById(int id) {
        postRepository.deleteByPostId(id);
    }

    public List<Post> findAllPostsForASpecificUser(int userId) {
       List<Post> posts = postRepository.fillAllThePostForAUser(userId);
       return posts;
    }

    public Post findPostWithId(int postId) {
        return postRepository.findByPostId(postId);
    }

    public Post updateWithTags(Post post) {
        return postRepository.save(post);
    }
}
