package com.dohatec.sharethoughts.repository;

import com.dohatec.sharethoughts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
