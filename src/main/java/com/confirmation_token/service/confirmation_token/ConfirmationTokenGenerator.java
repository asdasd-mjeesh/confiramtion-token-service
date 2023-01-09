package com.confirmation_token.service.confirmation_token;

import com.confirmation_token.model.dto.request.outgoing.ConfirmationTokenDetailsRequest;

public interface ConfirmationTokenGenerator {
    ConfirmationTokenDetailsRequest generate();
}
