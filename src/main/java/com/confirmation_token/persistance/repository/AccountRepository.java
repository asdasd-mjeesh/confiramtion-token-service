package com.confirmation_token.persistance.repository;

import com.confirmation_token.persistance.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, Long> {

    Optional<Account> findByConfirmationToken(String token);
}
