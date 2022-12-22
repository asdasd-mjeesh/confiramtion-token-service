package com.confirmation_token.api.rest_controller;

import com.confirmation_token.model.dto.response.AccountResponse;
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
    private final AccountResponseMapper accountResponseMapper;

    @GetMapping(value = "/")
    public ResponseEntity<AccountResponse> getByConfirmationToken(@RequestParam(name = "token") String token) {
        var account = accountService.getByConfirmationToken(token);
        var accountResponse = accountResponseMapper.map(account);
        return ResponseEntity.ok(accountResponse);
    }
}
