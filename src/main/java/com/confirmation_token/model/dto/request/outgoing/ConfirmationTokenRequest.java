package com.confirmation_token.model.dto.request.outgoing;

import com.confirmation_token.model.ConfirmationToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationTokenRequest {
    private String email;
    private ConfirmationToken token;
}
