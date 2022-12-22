package com.confirmation_token.model.dto.request.incoming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountConfirmationRequest {
    private String username;
    private String email;
    private String contact;
    private LocalDateTime createdAt;
}
