package com.account_confirmation.api.rest_controller;

import com.account_confirmation.model.dto.response.AccountResponse;
import com.account_confirmation.service.mapper.response.AccountResponseMapper;
import com.account_confirmation.service.account.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts-confirmation")
public class AccountControllerV1 {
    private final AccountService accountService;
    private final AccountResponseMapper accountResponseMapper;

    @GetMapping("/")
    @Operation(
            tags = { "accounts-confirmation" }
    )
    public ResponseEntity<AccountResponse> getByConfirmationToken(@RequestParam(name = "token") String token) {
        var account = accountService.getByConfirmationToken(token);
        var accountResponse = accountResponseMapper.map(account);
        return ResponseEntity.ok(accountResponse);
    }
}
