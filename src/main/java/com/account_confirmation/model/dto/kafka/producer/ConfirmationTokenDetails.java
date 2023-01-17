package com.account_confirmation.model.dto.kafka.producer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationTokenDetails {
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
}
