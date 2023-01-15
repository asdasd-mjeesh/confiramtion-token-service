package com.account_confirmation.api.rest_controller;

import com.account_confirmation.model.dto.response.AccountResponse;
import com.account_confirmation.service.mapper.response.AccountResponseMapper;
import com.account_confirmation.service.account.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts-confirmation")
public class AccountControllerV1 {
    private final AccountService accountService;
    private final AccountResponseMapper accountResponseMapper;

    @GetMapping("/{token}")
    @Operation(
            tags = { "accounts-confirmation" },
            summary = "gives account info along with confirmation token details",
            description = "gives account info along with confirmation token details by passed confirmation token",
            parameters = { @Parameter(
                    name = "token",
                    description = "confirmation token which was generated and send to user email",
                    in = ParameterIn.PATH,
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = String.class),
                            mediaType = MediaType.TEXT_PLAIN_VALUE
                    ))
            },
            responses = { @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = AccountResponse.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    public ResponseEntity<AccountResponse> getByConfirmationToken(@PathVariable(name = "token") String token) {
        var account = accountService.getByConfirmationToken(token);
        var accountResponse = accountResponseMapper.map(account);
        return ResponseEntity.ok(accountResponse);
    }
}
