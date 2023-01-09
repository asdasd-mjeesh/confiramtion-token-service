package com.confirmation_token.service.mapper.request.outgoing;

import com.confirmation_token.model.dto.request.outgoing.AccountRequest;
import com.confirmation_token.model.dto.request.outgoing.ConfirmationTokenDetailsRequest;
import com.confirmation_token.persistance.entity.Account;
import com.confirmation_token.service.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountOutgoingRequestMapper implements Mapper<AccountRequest, Account> {

    @Override
    public AccountRequest map(Account from) {
        return AccountRequest.builder()
                .email(from.getEmail())
                .username(from.getUsername())
                .confirmationTokenDetails(ConfirmationTokenDetailsRequest.builder()
                        .token(from.getConfirmationToken())
                        .createdAt(from.getCreatedAt())
                        .expiredAt(from.getExpiredAt())
                        .build())
                .build();
    }

    @Override
    public List<AccountRequest> map(List<Account> from) {
        return from.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
