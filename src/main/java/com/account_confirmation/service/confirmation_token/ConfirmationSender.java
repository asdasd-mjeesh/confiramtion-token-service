package com.account_confirmation.service.confirmation_token;

import com.account_confirmation.model.dto.kafka.producer.AccountConfirmation;

public interface ConfirmationSender {

    void sendConfirmationToken(AccountConfirmation tokenRequest);
}
