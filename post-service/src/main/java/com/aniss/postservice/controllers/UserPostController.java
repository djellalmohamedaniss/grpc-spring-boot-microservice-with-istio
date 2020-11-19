package com.aniss.postservice.controllers;

import com.aniss.postservice.clients.IUserClient;
import com.aniss.postservice.entities.Post;
import com.aniss.postservice.models.User;
import com.aniss.postservice.services.IPostService;
import io.grpc.StatusRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/{user}/posts")
public class UserPostController {

    @Autowired
    private IPostService postService;

    @Autowired
    private IUserClient userClient;

    @GetMapping
    public HttpEntity<List<Post>> all(@PathVariable(name = "user") Long user)
    {
        try
        {
            User userModel = userClient.getUserById(user);
            return ResponseEntity.ok(postService.all(userModel));
        }
        catch (StatusRuntimeException exception)
        {
                return ResponseEntity.notFound().build();
        }
    }

}
