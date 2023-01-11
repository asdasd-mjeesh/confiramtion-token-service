package com.account_confirmation.service.validator;

public interface ApplicationModelValidator {
    <E> String validate(E model);
}
