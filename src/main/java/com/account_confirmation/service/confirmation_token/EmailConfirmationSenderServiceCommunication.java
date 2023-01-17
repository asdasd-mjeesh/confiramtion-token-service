package com.account_confirmation.service.confirmation_token;

import com.account_confirmation.model.dto.kafka.producer.AccountConfirmation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailConfirmationSenderServiceCommunication implements ConfirmationSender {
    private final KafkaTemplate<String, AccountConfirmation> accountConfirmationKafkaTemplate;

    @Value("${kafka.topic.names.mail.account-confirmation-message}")
    private String confirmationTopicName;

    @Override
    public void sendConfirmationToken(AccountConfirmation accountConfirmation) {
        System.out.println("HERE IT IS");
        accountConfirmationKafkaTemplate.send(confirmationTopicName, accountConfirmation);
        log.info("Confirmation token={} has been send", accountConfirmation);
    }
}
