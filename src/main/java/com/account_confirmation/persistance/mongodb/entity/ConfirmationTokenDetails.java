package com.account_confirmation.persistance.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ConfirmationTokenDetails {
    @Indexed(unique=true)
    private String confirmationToken;

    private LocalDateTime createdAt;

    private LocalDateTime expiredAt;
}
