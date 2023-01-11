package com.account_confirmation.service.confirmation_token;

import com.account_confirmation.model.dto.request.outgoing.ConfirmationTokenDetailsRequest;

public interface ConfirmationTokenGenerator {
    ConfirmationTokenDetailsRequest generate();
}
