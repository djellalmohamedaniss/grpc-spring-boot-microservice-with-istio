package com.aniss.postservice.clients;

import com.aniss.UserEntityResponse;
import com.aniss.postservice.models.User;

public interface IUserClient {
    User getUserById(Long id);
}
