package com.confirmation_token.service.account;

import com.confirmation_token.exception.ConfirmationTokenSendingFailedException;
import com.confirmation_token.persistance.entity.Account;
import com.confirmation_token.service.confirmation_token.ConfirmationSender;
import com.confirmation_token.service.confirmation_token.ConfirmationTokenGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountConfirmationExecutorImpl implements AccountConfirmationExecutor {
    private final AccountService accountService;
    private final ConfirmationSender confirmationSender;
    private final ConfirmationTokenGenerator tokenGenerator;

    @Override
    public Account execute(Account account) {
        String confirmToken = tokenGenerator.generate();
        account.setConfirmationToken(confirmToken);

        accountService.save(account);
        confirmationSender.sendConfirmationToken(confirmToken);
        return account;
    }
}
