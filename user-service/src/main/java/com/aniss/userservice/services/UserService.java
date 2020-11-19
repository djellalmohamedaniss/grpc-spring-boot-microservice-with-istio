package com.aniss.userservice.services;

import com.aniss.userservice.entities.User;
import com.aniss.userservice.repositories.IUserRepository;
import com.aniss.userservice.requests.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public User create(CreateUser createUser) {
        User user = new User().setName(createUser.getName());
        return repository.save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }
}
