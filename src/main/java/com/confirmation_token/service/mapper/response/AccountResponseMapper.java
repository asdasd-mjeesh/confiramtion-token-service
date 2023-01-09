package com.confirmation_token.service.mapper.response;

import com.confirmation_token.model.dto.response.AccountResponse;
import com.confirmation_token.model.dto.response.ConfirmationTokenDetailsResponse;
import com.confirmation_token.persistance.entity.Account;
import com.confirmation_token.service.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountResponseMapper implements Mapper<AccountResponse, Account> {

    @Override
    public AccountResponse map(Account from) {
        return AccountResponse.builder()
                .confirmationTokenDetailsResponse(ConfirmationTokenDetailsResponse.builder()
                        .token(from.getConfirmationToken())
                        .createdAt(from.getCreatedAt())
                        .expiredAt(from.getExpiredAt())
                        .build())
                .username(from.getUsername())
                .contact(from.getContact())
                .email(from.getEmail())
                .build();
    }

    @Override
    public List<AccountResponse> map(List<Account> from) {
        return from.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
