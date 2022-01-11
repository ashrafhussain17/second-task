package com.dohatec.sharethoughts.repository;

import com.dohatec.sharethoughts.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByPostId(int postId);
    void deleteByPostId(int postId);
    @Query(value = "select * from Post where user_id = ?1", nativeQuery = true)
    List<Post> fillAllThePostForAUser(int id);
}
