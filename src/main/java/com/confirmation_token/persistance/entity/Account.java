package com.confirmation_token.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Account {
    @Id
    private String username;
    private String email;
    private String contact;
    private LocalDateTime createdAt;
    private String confirmationToken;
}
