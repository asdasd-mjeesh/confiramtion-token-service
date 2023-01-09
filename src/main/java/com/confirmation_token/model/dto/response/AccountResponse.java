package com.confirmation_token.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private String username;
    private String email;
    private String contact;
    private ConfirmationTokenDetailsResponse confirmationTokenDetailsResponse;
}
