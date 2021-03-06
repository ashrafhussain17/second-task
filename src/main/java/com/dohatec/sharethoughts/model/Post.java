package com.dohatec.sharethoughts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User apiUser;

    @ManyToMany(targetEntity = Tags.class,
            cascade = {
            CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(name = "post_tags",
            joinColumns = { @JoinColumn(name = "post_id", referencedColumnName = "postId")},
            inverseJoinColumns = { @JoinColumn(name = "tag_id", referencedColumnName = "tagId") })
    private Set<Tags> postTags = new HashSet<>();

    public void addTag(Tags tag) {
        if(postTags == null){
            postTags = new HashSet<>();
        }
        postTags.add(tag);
    }
}
