package com.account_confirmation.service.account;

import com.account_confirmation.exception.EntityNotFoundException;
import com.account_confirmation.persistance.mongodb.entity.Account;
import com.account_confirmation.persistance.mongodb.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountDatabaseService implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getByConfirmationToken(String token) {
        Optional<Account> account = accountRepository.findByConfirmationTokenDetails_ConfirmationToken(token);
        if (account.isPresent()) {
            return account.get();
        }
        throw new EntityNotFoundException(String.format("Account with confirmation token=%s not found", token));
    }

    @Override
    public void deleteAllCreatedMoreThan(LocalDateTime time) {
        //
    }
}
