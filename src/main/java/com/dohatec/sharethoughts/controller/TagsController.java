package com.dohatec.sharethoughts.controller;

import com.dohatec.sharethoughts.model.Post;
import com.dohatec.sharethoughts.model.Tags;
import com.dohatec.sharethoughts.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    private TagsService tagsService;

    @GetMapping("/all")
    public ResponseEntity<List<Tags>> getAllTags(){
        List<Tags> allTheTags = tagsService.getAllTheTags();
        if(allTheTags.size() <= 0){
            throw new RuntimeException("There is no tags here");
        }
        return new ResponseEntity<>(allTheTags, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Tags> createPost(@Valid @RequestBody Tags tag){
        Tags tag1 = tagsService.createNewTag(tag);
        return  new ResponseEntity<>(tag1, HttpStatus.CREATED);
    }
}
