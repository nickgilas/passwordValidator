package com.nick.validator.strategies;

import com.nick.validator.ValidationMessageType;
import com.nick.validator.ValidationUtil;

public class ValidateMinimumLength implements ValidationStrategy {

	public static final int MIN_PASSOWRD_LENGHT = 5;
	
	@Override
    public boolean validate(String value) {

        return !ValidationUtil.isLengthLessThen(MIN_PASSOWRD_LENGHT, value);
    }

	@Override
    public ValidationMessageType getValidationMessageIfFailed() {

        return ValidationMessageType.STRING_TOO_SHORT;
    }

}
