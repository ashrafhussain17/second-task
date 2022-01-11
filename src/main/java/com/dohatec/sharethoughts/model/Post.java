package com.dohatec.sharethoughts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User apiUser;

    public Post() {
    }

    public Post(int postId, String description, User apiUser) {
        this.postId = postId;
        this.description = description;
        this.apiUser = apiUser;
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

    public User getApiUser() {
        return apiUser;
    }

    public void setApiUser(User apiUser) {
        this.apiUser = apiUser;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", description='" + description + '\'' +
                ", apiUser=" + apiUser +
                '}';
    }
}
