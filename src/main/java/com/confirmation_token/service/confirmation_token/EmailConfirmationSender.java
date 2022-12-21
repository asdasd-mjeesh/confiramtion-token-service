package com.confirmation_token.service.confirmation_token;

import org.springframework.stereotype.Service;

@Service
public class EmailConfirmationSender implements ConfirmationSender {

    @Override
    public void sendConfirmationToken(String token) {
        System.out.println(String.format("Token=%s send", token));
    }
}
