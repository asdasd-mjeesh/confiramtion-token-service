package com.confirmation_token.service.mapper;

import com.confirmation_token.dto.request.AccountConfirmationRequest;
import com.confirmation_token.persistance.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRequestMapper implements Mapper<Account, AccountConfirmationRequest> {

    @Override
    public Account map(AccountConfirmationRequest from) {
        return Account.builder()
                .username(from.getUsername())
                .contact(from.getContact())
                .email(from.getEmail())
                .createdAt(from.getCreatedAt())
                .build();
    }

    @Override
    public List<Account> map(List<AccountConfirmationRequest> from) {
        return from.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
