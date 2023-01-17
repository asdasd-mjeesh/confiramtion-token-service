package com.account_confirmation.service.mapper.request.incoming;

import com.account_confirmation.model.dto.kafka.consumer.NewAccount;
import com.account_confirmation.persistance.mongodb.entity.Account;
import com.account_confirmation.persistance.mongodb.entity.ConfirmationTokenDetails;
import com.account_confirmation.service.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountIncomingRequestMapper implements Mapper<Account, NewAccount> {

    @Override
    public Account map(NewAccount from) {
        return Account.builder()
                .username(from.getUsername())
                .contact(from.getContact())
                .email(from.getEmail())
                .confirmationTokenDetails(ConfirmationTokenDetails.builder()
                        .createdAt(from.getCreatedAt())
                        .build())
                .build();
    }

    @Override
    public List<Account> map(List<NewAccount> from) {
        return from.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
