package com.aniss.postservice.services;

import com.aniss.postservice.entities.Post;
import com.aniss.postservice.models.User;
import com.aniss.postservice.repositories.PostRepository;
import com.aniss.postservice.requests.CreatePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository repository;

    @Override
    public Post create(CreatePost createPost) {
        Post post = new Post().setUser(createPost.getUser())
                .setContent(createPost.getContent());
        return repository.save(post);
    }

    @Override
    public Optional<Post> one(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Post> all(User user) {
        return repository.findAllByUser(user.getId());
    }

    @Override
    public void bulkDelete(User user) {
        repository.deletePostsByUser(user.getId());
    }
}
