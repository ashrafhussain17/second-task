package com.dohatec.sharethoughts.repository;

import com.dohatec.sharethoughts.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tags, Long> {
}
