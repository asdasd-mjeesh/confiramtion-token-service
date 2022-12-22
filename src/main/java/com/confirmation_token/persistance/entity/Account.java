package com.confirmation_token.persistance.entity;

import com.confirmation_token.model.ConfirmationToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Account {
    @Id
    private String id;

    @Indexed(unique=true)
    private String username;

    @Indexed(unique=true)
    private String email;

    @Indexed(unique=true)
    private String contact;

    @Indexed(unique=true)
    private ConfirmationToken confirmationToken;

    private LocalDateTime createdAt;
}
