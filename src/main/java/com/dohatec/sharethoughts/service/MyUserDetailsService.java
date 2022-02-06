package com.dohatec.sharethoughts.service;

import com.dohatec.sharethoughts.model.MyUserDetails;
import com.dohatec.sharethoughts.model.User;
import com.dohatec.sharethoughts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>  user = userRepository.findByUserName(username);

        user.orElseThrow(() -> new UsernameNotFoundException(username + " Not found"));

        return user.map(MyUserDetails::new).get();
    }
}
