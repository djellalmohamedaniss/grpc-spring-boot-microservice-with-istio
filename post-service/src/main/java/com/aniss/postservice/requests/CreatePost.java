package com.aniss.postservice.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreatePost {
    @NotEmpty(message = "content must not empty")
    @Size(min = 5, max = 100)
    private String content;
    @NotNull(message = "user must be specified")
    private Long user;
}
