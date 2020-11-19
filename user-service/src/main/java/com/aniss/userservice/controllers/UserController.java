package com.aniss.userservice.controllers;

import com.aniss.userservice.entities.User;
import com.aniss.userservice.requests.CreateUser;
import com.aniss.userservice.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public HttpEntity<User> create(@RequestBody @Valid CreateUser createUser)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(createUser));
    }

    @GetMapping("/{id}")
    public HttpEntity<User> one(@PathVariable(name = "id") Long id)
    {
        Optional<User> user = userService.get(id);
        if ( user.isEmpty() )
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable(name = "id") Long id)
    {
        Optional<User> user = userService.get(id);
        if ( user.isPresent() )
        {
            userService.delete(user.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
