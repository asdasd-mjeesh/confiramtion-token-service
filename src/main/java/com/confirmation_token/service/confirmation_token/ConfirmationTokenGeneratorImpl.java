package com.confirmation_token.service.confirmation_token;

import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenGeneratorImpl implements ConfirmationTokenGenerator {

    @Override
    public String generate() {
        return "asd-token";
    }
}
