package com.aniss.userservice.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CreateUser {
    @NotEmpty(message = "name must not be empty")
    @Size(min = 4, max = 20, message = "name size must be between {min} and {max}")
    String name;
}
