package com.confirmation_token.service.confirmation_token;

import com.confirmation_token.model.dto.request.outgoing.ConfirmationTokenRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailConfirmationSenderServiceCommunication implements ConfirmationSender {
    private final KafkaTemplate<String, ConfirmationTokenRequest> kafkaTemplate;

    @Override
    public void sendConfirmationToken(ConfirmationTokenRequest tokenRequest) {
        kafkaTemplate.send("mail_confirmation_message", tokenRequest);
        log.info("Confirmation token={} been send", tokenRequest);
        System.out.println(String.format("TokenRequest=%s been send", tokenRequest));
    }
}
