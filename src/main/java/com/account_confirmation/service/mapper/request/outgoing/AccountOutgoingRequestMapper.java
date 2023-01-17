package com.account_confirmation.service.mapper.request.outgoing;

import com.account_confirmation.model.dto.kafka.producer.AccountConfirmation;
import com.account_confirmation.model.dto.kafka.producer.ConfirmationTokenDetails;
import com.account_confirmation.persistance.mongodb.entity.Account;
import com.account_confirmation.service.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountOutgoingRequestMapper implements Mapper<AccountConfirmation, Account> {

    @Override
    public AccountConfirmation map(Account from) {
        return AccountConfirmation.builder()
                .email(from.getEmail())
                .username(from.getUsername())
                .confirmationTokenDetails(ConfirmationTokenDetails.builder()
                        .token(from.getConfirmationTokenDetails().getConfirmationToken())
                        .createdAt(from.getConfirmationTokenDetails().getCreatedAt())
                        .expiredAt(from.getConfirmationTokenDetails().getExpiredAt())
                        .build())
                .build();
    }

    @Override
    public List<AccountConfirmation> map(List<Account> from) {
        return from.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
