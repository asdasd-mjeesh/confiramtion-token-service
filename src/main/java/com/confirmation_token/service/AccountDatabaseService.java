package com.confirmation_token.service;

import com.confirmation_token.exception.EntityNotFoundException;
import com.confirmation_token.persistance.entity.Account;
import com.confirmation_token.persistance.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountDatabaseService implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getByConfirmationToken(String token) {
        Optional<Account> account = accountRepository.findByConfirmationToken(token);
        if (account.isPresent()) {
            return account.get();
        }
        throw new EntityNotFoundException(String.format("Account with confirmation token=%s not found", token));
    }

    @Override
    public boolean deleteById(Long id) {
        accountRepository.deleteById(id);
        return accountRepository.findById(id).isEmpty();
    }

    @Override
    public void deleteAllCreatedMoreThan(LocalDateTime time) {
        //
    }
}
