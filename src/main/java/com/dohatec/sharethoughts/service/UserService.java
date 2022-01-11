package com.dohatec.sharethoughts.service;

import com.dohatec.sharethoughts.model.User;
import com.dohatec.sharethoughts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public  User createNewUser(User user) {
        User newUser = userRepository.save(new User(user.getUserId(), user.getUsername(), user.getEmail(), user.getPhoneNo(), user.getPosts()));
        return newUser;
    }
}
