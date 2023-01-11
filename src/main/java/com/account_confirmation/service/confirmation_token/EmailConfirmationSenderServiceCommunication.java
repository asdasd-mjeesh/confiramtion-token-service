package com.account_confirmation.service.confirmation_token;

import com.account_confirmation.model.dto.request.outgoing.AccountRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailConfirmationSenderServiceCommunication implements ConfirmationSender {
    private final KafkaTemplate<String, AccountRequest> kafkaTemplate;

    @Override
    public void sendConfirmationToken(AccountRequest accountRequest) {
        kafkaTemplate.send("mail_confirmation_message", accountRequest);
        log.info("Confirmation token={} has been send", accountRequest);
    }
}
