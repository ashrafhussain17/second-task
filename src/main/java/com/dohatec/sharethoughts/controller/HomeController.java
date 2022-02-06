package com.dohatec.sharethoughts.controller;

import com.dohatec.sharethoughts.model.Tags;
import com.dohatec.sharethoughts.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
       return "Hello world";
    }
}
