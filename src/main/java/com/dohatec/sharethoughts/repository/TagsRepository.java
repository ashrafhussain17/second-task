package com.dohatec.sharethoughts.repository;

import com.dohatec.sharethoughts.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagsRepository extends JpaRepository<Tags, Long> {
    Tags findByTagId(UUID tagId);
}
