package com.confirmation_token.api.rest_controller;

import com.confirmation_token.dto.request.AccountRequest;
import com.confirmation_token.dto.response.AccountResponse;
import com.confirmation_token.service.account.AccountConfirmationExecutor;
import com.confirmation_token.service.mapper.AccountRequestMapper;
import com.confirmation_token.service.mapper.AccountResponseMapper;
import com.confirmation_token.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountControllerV1 {
    private final AccountService accountService;
    private final AccountConfirmationExecutor accountConfirmationExecutor;
    private final AccountRequestMapper accountRequestMapper;
    private final AccountResponseMapper accountResponseMapper;

    @PostMapping(value = "/")
    public ResponseEntity<AccountResponse> save(@RequestBody AccountRequest accountRequest) {
        var account = accountRequestMapper.map(accountRequest);
        account = accountConfirmationExecutor.execute(account);
        var accountResponse = accountResponseMapper.map(account);
        return ResponseEntity.ok(accountResponse);
    }

    @GetMapping(value = "/{token}")
    public ResponseEntity<AccountResponse> getByConfirmationToken(@PathVariable(name = "token") String token) {
        var account = accountService.getByConfirmationToken(token);
        var accountResponse = accountResponseMapper.map(account);
        return ResponseEntity.ok(accountResponse);
    }
}
