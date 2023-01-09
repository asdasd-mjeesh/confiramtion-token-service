package com.confirmation_token.service.validator;

public interface ApplicationModelValidator {
    <E> String validate(E model);
}
