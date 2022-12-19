package com.confirmation_token.persistance.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Account {
    @Id
    private String id;
    private String email;
    private String contact;
    private LocalDateTime createdAt;
    private String confirmationToken;
}
