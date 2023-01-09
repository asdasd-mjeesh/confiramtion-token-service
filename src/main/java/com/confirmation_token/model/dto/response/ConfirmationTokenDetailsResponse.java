package com.confirmation_token.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationTokenDetailsResponse {
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
}
