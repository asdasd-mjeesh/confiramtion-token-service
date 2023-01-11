package com.account_confirmation.service.account;

import com.account_confirmation.persistance.mongodb.entity.Account;

import java.time.LocalDateTime;

public interface AccountService {
    Account save(Account account);
    Account getByConfirmationToken(String token);
    void deleteAllCreatedMoreThan(LocalDateTime time);
}
