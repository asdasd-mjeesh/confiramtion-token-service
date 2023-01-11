package com.account_confirmation.service.confirmation_token;

import com.account_confirmation.model.dto.request.outgoing.AccountRequest;

public interface ConfirmationSender {

    void sendConfirmationToken(AccountRequest tokenRequest);
}
