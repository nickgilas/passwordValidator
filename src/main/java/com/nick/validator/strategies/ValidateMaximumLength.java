package com.nick.validator.strategies;

import com.nick.validator.ValidationMessageType;
import com.nick.validator.ValidationUtil;

public class ValidateMaximumLength implements ValidationStrategy {

	private static final int MAX_PASSWORD_LENGTH = 12;
	
	@Override
	public boolean validate(String value) {
		
		return !ValidationUtil.isLengthGreaterThen(MAX_PASSWORD_LENGTH, value);
		
	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {
		
		return ValidationMessageType.STRING_TOO_LONG;
		
	}

}
