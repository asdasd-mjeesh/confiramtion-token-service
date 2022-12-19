package com.confirmation_token.service;

import com.confirmation_token.persistance.entity.Account;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AccountService {
    Account save(Account account);
    Account getByConfirmationToken(String token);
    boolean deleteById(Long id);
    void deleteAllCreatedMoreThan(LocalDateTime time);
}
