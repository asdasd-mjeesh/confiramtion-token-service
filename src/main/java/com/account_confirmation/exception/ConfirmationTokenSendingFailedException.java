package com.account_confirmation.exception;

public class ConfirmationTokenSendingFailedException extends RuntimeException {

    public ConfirmationTokenSendingFailedException(String message) {
        super(message);
    }
}
