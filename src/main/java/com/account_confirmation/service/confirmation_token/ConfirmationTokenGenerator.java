package com.account_confirmation.service.confirmation_token;

import com.account_confirmation.model.dto.kafka.producer.ConfirmationTokenDetails;

public interface ConfirmationTokenGenerator {
    ConfirmationTokenDetails generate();
}
