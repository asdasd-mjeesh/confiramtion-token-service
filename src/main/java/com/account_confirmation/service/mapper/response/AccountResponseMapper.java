package com.account_confirmation.service.mapper.response;

import com.account_confirmation.model.dto.response.AccountResponse;
import com.account_confirmation.model.dto.response.ConfirmationTokenDetailsResponse;
import com.account_confirmation.persistance.mongodb.entity.Account;
import com.account_confirmation.service.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountResponseMapper implements Mapper<AccountResponse, Account> {

    @Override
    public AccountResponse map(Account from) {
        return AccountResponse.builder()
                .confirmationTokenDetailsResponse(ConfirmationTokenDetailsResponse.builder()
                        .token(from.getConfirmationTokenDetails().getConfirmationToken())
                        .createdAt(from.getConfirmationTokenDetails().getCreatedAt())
                        .expiredAt(from.getConfirmationTokenDetails().getExpiredAt())
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
