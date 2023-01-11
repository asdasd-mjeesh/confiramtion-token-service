package com.account_confirmation.persistance.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private ConfirmationTokenDetails confirmationTokenDetails;
}
