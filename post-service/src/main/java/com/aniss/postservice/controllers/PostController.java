package com.aniss.postservice.controllers;

import com.aniss.postservice.clients.IUserClient;
import com.aniss.postservice.entities.Post;
import com.aniss.postservice.requests.CreatePost;
import com.aniss.postservice.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("/{id}")
    public HttpEntity<Post> one(@PathVariable(name = "id") Long id)
    {
        Optional<Post> post = postService.one(id);
        return post.<HttpEntity<Post>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public HttpEntity<Post> create(@RequestBody @Valid CreatePost createPost)
    {
        Post post = postService.create(createPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

}
