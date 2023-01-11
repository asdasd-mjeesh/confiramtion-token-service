package com.account_confirmation.service.account;

import com.account_confirmation.exception.ModelValidationException;
import com.account_confirmation.model.dto.request.incoming.AccountConfirmationRequest;
import com.account_confirmation.persistance.mongodb.entity.Account;
import com.account_confirmation.service.confirmation_token.ConfirmationSender;
import com.account_confirmation.service.confirmation_token.ConfirmationTokenGenerator;
import com.account_confirmation.service.mapper.request.incoming.AccountIncomingRequestMapper;
import com.account_confirmation.service.mapper.request.outgoing.AccountOutgoingRequestMapper;
import com.account_confirmation.service.validator.ApplicationModelValidator;
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
        account.getConfirmationTokenDetails().setConfirmationToken(confirmToken.getToken());
        account.getConfirmationTokenDetails().setExpiredAt(confirmToken.getExpiredAt());
//        accountService.save(account);

        var accountMailConfirmationRequest = accountOutgoingRequestMapper.map(account);
        confirmationSender.sendConfirmationToken(accountMailConfirmationRequest);
        return account;
    }
}
