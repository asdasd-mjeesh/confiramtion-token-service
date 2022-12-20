package com.confirmation_token.service.account;

import com.confirmation_token.persistance.entity.Account;

public interface AccountConfirmationExecutor {
    Account execute(Account account);
}
