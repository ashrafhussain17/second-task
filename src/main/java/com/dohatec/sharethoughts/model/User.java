package com.dohatec.sharethoughts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apiUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "username")
    @NotBlank
    private String username;

    @Column(name = "email")
    @NotEmpty
    @Email
    private String email;

    @Column(name = "phoneNo")
    private String phoneNo;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "apiUser", cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<>();

//    @Column(name = "createdAt")
//    private LocalDateTime createdAt;

//    public User() {
//    }
//
//    public User(int userId, String username, String email, String phoneNo, Set<Post> posts) {
//        this.userId = userId;
//        this.username = username;
//        this.email = email;
//        this.phoneNo = phoneNo;
//        this.posts = posts;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNo() {
//        return phoneNo;
//    }
//
//    public void setPhoneNo(String phoneNo) {
//        this.phoneNo = phoneNo;
//    }
//
//    public Set<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(Set<Post> posts) {
//        this.posts = posts;
//        for(Post post: posts){
//            post.setApiUser(this);
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "userId=" + userId +
//                ", username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNo='" + phoneNo + '\'' +
//                ", posts=" + posts +
//                '}';
//    }
}