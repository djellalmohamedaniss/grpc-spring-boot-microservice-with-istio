package com.aniss.userservice.repositories;

import com.aniss.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}
