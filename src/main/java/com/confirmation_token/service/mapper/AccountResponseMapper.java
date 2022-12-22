package com.confirmation_token.service.mapper;

import com.confirmation_token.model.dto.response.AccountResponse;
import com.confirmation_token.persistance.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountResponseMapper implements Mapper<AccountResponse, Account> {

    @Override
    public AccountResponse map(Account from) {
        return AccountResponse.builder()
                .confirmationToken(from.getConfirmationToken())
                .username(from.getUsername())
                .contact(from.getContact())
                .email(from.getEmail())
                .createdAt(from.getCreatedAt())
                .build();
    }

    @Override
    public List<AccountResponse> map(List<Account> from) {
        return from.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
