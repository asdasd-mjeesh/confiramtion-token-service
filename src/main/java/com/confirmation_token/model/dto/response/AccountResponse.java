package com.confirmation_token.model.dto.response;

import com.confirmation_token.model.ConfirmationToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private String username;
    private String email;
    private String contact;
    private LocalDateTime createdAt;
    private ConfirmationToken confirmationToken;
}
