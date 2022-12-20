package com.confirmation_token.exception;

public class ConfirmationTokenSendingFailedException extends RuntimeException {

    public ConfirmationTokenSendingFailedException(String message) {
        super(message);
    }
}
