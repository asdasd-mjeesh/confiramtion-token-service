package com.account_confirmation.model.dto.request.outgoing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private String email;
    private String username;
    private ConfirmationTokenDetailsRequest confirmationTokenDetails;
}
