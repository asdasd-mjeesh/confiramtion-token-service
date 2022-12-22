package com.confirmation_token.service.account;

import com.confirmation_token.model.dto.request.incoming.AccountConfirmationRequest;
import com.confirmation_token.model.dto.request.outgoing.ConfirmationTokenRequest;
import com.confirmation_token.persistance.entity.Account;
import com.confirmation_token.service.confirmation_token.ConfirmationSender;
import com.confirmation_token.service.confirmation_token.ConfirmationTokenGenerator;
import com.confirmation_token.service.mapper.AccountRequestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountConfirmationExecutorImpl implements AccountConfirmationExecutor {
    private final AccountService accountService;
    private final AccountRequestMapper accountRequestMapper;
    private final ConfirmationSender confirmationSender;
    private final ConfirmationTokenGenerator tokenGenerator;

    @KafkaListener(topics = "account_confirmation", groupId = "account_confirmation_group_id")
    public void execute(AccountConfirmationRequest accountConfirmationRequest) {
        Account account = accountRequestMapper.map(accountConfirmationRequest);
        this.execute(account);
        log.info("Confirmation for account={} been send", account);
    }

    @Override
    public Account execute(Account account) {
        var confirmToken = tokenGenerator.generate();
        account.setConfirmationToken(confirmToken);
        accountService.save(account);

        var confirmationTokenRequest = ConfirmationTokenRequest.builder()
                .token(confirmToken)
                .email(account.getEmail())
                .build();
        confirmationSender.sendConfirmationToken(confirmationTokenRequest);
        return account;
    }
}
