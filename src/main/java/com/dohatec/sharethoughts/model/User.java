package com.dohatec.sharethoughts.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "apiUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNo")
    private String phoneNo;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User() {
    }

    public User(int userId, String username, String email, String phoneNo, List<Post> posts) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phoneNo = phoneNo;
        this.posts = posts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", posts=" + posts +
                '}';
    }
}