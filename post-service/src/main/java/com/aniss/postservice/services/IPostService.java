package com.aniss.postservice.services;

import com.aniss.postservice.entities.Post;
import com.aniss.postservice.models.User;
import com.aniss.postservice.requests.CreatePost;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    Post create(CreatePost createPost);
    Optional<Post> one(Long id);
    List<Post> all(User user);
    void bulkDelete(User user);
}
