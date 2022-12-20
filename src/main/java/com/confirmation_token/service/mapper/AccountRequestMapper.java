package com.confirmation_token.service.mapper;

import com.confirmation_token.dto.request.AccountRequest;
import com.confirmation_token.persistance.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRequestMapper implements Mapper<Account, AccountRequest> {

    @Override
    public Account map(AccountRequest from) {
        return Account.builder()
                .username(from.getUsername())
                .contact(from.getContact())
                .email(from.getEmail())
                .createdAt(from.getCreatedAt())
                .build();
    }

    @Override
    public List<Account> map(List<AccountRequest> from) {
        return from.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
