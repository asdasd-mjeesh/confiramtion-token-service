package com.account_confirmation.model.dto.request.incoming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountConfirmationRequest {
    @Length(min = 8, max = 40)
    private String username;

    @Email
    private String email;

    @Length(min = 13, max = 13)
    private String contact;

    @PastOrPresent
    private LocalDateTime createdAt;
}
