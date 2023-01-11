package com.account_confirmation.persistance.mongodb.repository;

import com.account_confirmation.persistance.mongodb.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, Long> {

    Optional<Account> findByConfirmationTokenDetails_ConfirmationToken(String token);
}
