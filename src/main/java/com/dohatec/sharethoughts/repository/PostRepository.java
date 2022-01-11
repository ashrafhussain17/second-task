package com.dohatec.sharethoughts.repository;

import com.dohatec.sharethoughts.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByPostId(int postId);
    void deleteByPostId(int postId);
}
