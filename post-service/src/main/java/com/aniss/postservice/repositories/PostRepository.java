package com.aniss.postservice.repositories;

import com.aniss.postservice.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    void deletePostsByUser(Long user);
    List<Post> findAllByUser(Long user);
}
