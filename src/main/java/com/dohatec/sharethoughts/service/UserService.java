package com.dohatec.sharethoughts.service;

import com.dohatec.sharethoughts.model.Post;
import com.dohatec.sharethoughts.model.User;
import com.dohatec.sharethoughts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserWithId(int userId) {
       User user =  userRepository.findByUserId(userId);
       return  user;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public  User createNewUser(User user) {
        User newUser = userRepository.save(new User(user.getUserId(), user.getUsername(), user.getEmail(), user.getPhoneNo(), user.getPosts()));
        return newUser;
    }

    @Transactional
    public void deleteUserById(int id) {
        userRepository.deleteByUserId(id);
    }
}
