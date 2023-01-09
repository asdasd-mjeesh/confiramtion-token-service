package com.confirmation_token.service.account;

import com.confirmation_token.exception.ModelValidationException;
import com.confirmation_token.model.dto.request.incoming.AccountConfirmationRequest;
import com.confirmation_token.persistance.entity.Account;
import com.confirmation_token.service.confirmation_token.ConfirmationSender;
import com.confirmation_token.service.confirmation_token.ConfirmationTokenGenerator;
import com.confirmation_token.service.mapper.request.incoming.AccountIncomingRequestMapper;
import com.confirmation_token.service.mapper.request.outgoing.AccountOutgoingRequestMapper;
import com.confirmation_token.service.validator.ApplicationModelValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountConfirmationExecutorImpl implements AccountConfirmationExecutor {
    private final AccountService accountService;
    private final AccountIncomingRequestMapper accountIncomingRequestMapper;
    private final AccountOutgoingRequestMapper accountOutgoingRequestMapper;
    private final ConfirmationSender confirmationSender;
    private final ConfirmationTokenGenerator tokenGenerator;
    private final ApplicationModelValidator applicationModelValidator;

    @KafkaListener(topics = "account_confirmation_token", groupId = "account_confirmation_group_id")
    public void execute(AccountConfirmationRequest accountConfirmationRequest) {
        String validationViolations = applicationModelValidator.validate(accountConfirmationRequest);
        if (!validationViolations.isBlank()) {
            log.error(validationViolations);
            throw new ModelValidationException(validationViolations);
        }

        Account account = accountIncomingRequestMapper.map(accountConfirmationRequest);
        this.execute(account);
        log.info("Confirmation for account={} has been send", account);
    }

    @Override
    public Account execute(Account account) {
        var confirmToken = tokenGenerator.generate();
        account.setConfirmationToken(confirmToken.getToken());
        account.setExpiredAt(confirmToken.getExpiredAt());
//        accountService.save(account);

        var accountMailConfirmationRequest = accountOutgoingRequestMapper.map(account);
        confirmationSender.sendConfirmationToken(accountMailConfirmationRequest);
        return account;
    }
}
