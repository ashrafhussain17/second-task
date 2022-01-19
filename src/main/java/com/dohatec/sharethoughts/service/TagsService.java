package com.dohatec.sharethoughts.service;

import com.dohatec.sharethoughts.model.Tags;
import com.dohatec.sharethoughts.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TagsService {

    @Autowired
    private TagsRepository tagsRepository;

    public List<Tags> getAllTheTags(){
        return tagsRepository.findAll();
    }

    public Tags createNewTag(Tags tag) {
        return tagsRepository.save(tag);
    }

    public Tags findTagWithId(UUID tagId) {
        return tagsRepository.findByTagId(tagId);
    }
}
