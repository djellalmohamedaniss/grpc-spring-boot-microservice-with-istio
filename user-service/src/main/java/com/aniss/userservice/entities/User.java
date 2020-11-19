package com.aniss.userservice.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
public class User {
    @GeneratedValue @Id private Long id;
    private String name;
    @CreationTimestamp private LocalDateTime createdAt;
}
