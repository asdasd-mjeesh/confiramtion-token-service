package com.account_confirmation.service.account;

import com.account_confirmation.persistance.mongodb.entity.Account;

public interface AccountConfirmationExecutor {
    Account execute(Account account);
}
