package com.account_confirmation.service.mapper.request.outgoing;

import com.account_confirmation.model.dto.request.outgoing.AccountRequest;
import com.account_confirmation.model.dto.request.outgoing.ConfirmationTokenDetailsRequest;
import com.account_confirmation.persistance.mongodb.entity.Account;
import com.account_confirmation.service.mapper.Mapper;
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
                        .token(from.getConfirmationTokenDetails().getConfirmationToken())
                        .createdAt(from.getConfirmationTokenDetails().getCreatedAt())
                        .expiredAt(from.getConfirmationTokenDetails().getExpiredAt())
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
