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

    @Transactional
    public Post createNewPost(Post post) {
        Post newPost = postRepository.save(post);
        System.out.println(post.getApiUser().getUserId());
        User user1 = userRepository.findByUserId(post.getApiUser().getUserId());
        if(user1.getUserId() == 8){
            throw new RuntimeException("Rollback should be done for user 8");
        }
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

    public List<Post> findAllPostsForASpecificUser(int userId) {
       List<Post> posts = postRepository.fillAllThePostForAUser(userId);
       return posts;
    }
}
