package com.account_confirmation;

import com.account_confirmation.model.dto.kafka.consumer.NewAccount;
import com.account_confirmation.service.account.AccountConfirmationExecutor;
import com.account_confirmation.service.mapper.request.incoming.AccountIncomingRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestCntrllr {
    private final AccountConfirmationExecutor accountConfirmationExecutor;
    private final AccountIncomingRequestMapper accountIncomingRequestMapper;

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody NewAccount newAccount) {
        var account = accountIncomingRequestMapper.map(newAccount);
        accountConfirmationExecutor.execute(account);
        return ResponseEntity.ok("ok");
    }
}
