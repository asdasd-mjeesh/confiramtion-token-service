package com.confirmation_token.service.confirmation_token;

import com.confirmation_token.model.dto.request.outgoing.ConfirmationTokenDetailsRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class ConfirmationTokenGeneratorImpl implements ConfirmationTokenGenerator {

    @Value("${confirmation.toke.expiration.minutes}")
    private Integer confirmationTokenExpirationTime;

    @Override
    public ConfirmationTokenDetailsRequest generate() {
        return ConfirmationTokenDetailsRequest.builder()
                .token(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plus(confirmationTokenExpirationTime, ChronoUnit.MINUTES))
                .build();
    }
}
