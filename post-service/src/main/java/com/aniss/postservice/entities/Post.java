package com.aniss.postservice.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Accessors(chain = true)
public class Post {
    @GeneratedValue @Id private Long id;
    private Long user;
    private String content;
}
