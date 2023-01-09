package com.confirmation_token.service.confirmation_token;

import com.confirmation_token.model.dto.request.outgoing.AccountRequest;

public interface ConfirmationSender {

    void sendConfirmationToken(AccountRequest tokenRequest);
}
