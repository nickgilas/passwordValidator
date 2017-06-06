package com.nick.validator.strategies;

import com.nick.validator.ValidationMessageType;

public interface ValidationStrategy {

    public boolean validate(String value);

    public ValidationMessageType getValidationMessageIfFailed();
}
