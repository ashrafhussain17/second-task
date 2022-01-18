package com.dohatec.sharethoughts.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PostDTO {

    private String description;
    private Set<Post> tags = new HashSet<>();
}
