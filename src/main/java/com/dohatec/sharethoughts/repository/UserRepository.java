package com.dohatec.sharethoughts.repository;

import com.dohatec.sharethoughts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(int userId);
    void deleteByUserId(int userId);

    Optional<User> findByUserName(String username);
}
