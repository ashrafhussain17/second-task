package com.dohatec.sharethoughts.model;

import javax.persistence.*;

@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Post() {
    }

    public Post(int postId, String description, User user) {
        this.postId = postId;
        this.description = description;
        this.user = user;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
