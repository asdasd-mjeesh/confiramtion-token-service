package com.confirmation_token.api.rest_controller;

import com.confirmation_token.persistance.entity.Account;
import com.confirmation_token.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountControllerV1 {
    private final AccountService accountService;

    @PostMapping(value = "/")
    public ResponseEntity<Account> save(@RequestBody Account account) {
        var savedAccount = accountService.save(account);
        return ResponseEntity.ok(savedAccount);
    }

    @GetMapping(value = "/{token}")
    public ResponseEntity<Account> getByConfirmationToken(@PathVariable(name = "token") String token) {
        var account = accountService.getByConfirmationToken(token);
        return ResponseEntity.ok(account);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
        boolean isDeleted = accountService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Deleted successfully");
        }
        return new ResponseEntity<>("Deletion error", HttpStatus.CONFLICT);
    }
}
