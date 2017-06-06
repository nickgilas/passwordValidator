package com.nick.validator.strategies;

import com.nick.validator.ValidationMessageType;

public class ValidateInvalidCharacter implements ValidationStrategy {

	@Override
	public boolean validate(String value) {

		for (Character tmp : value.toCharArray()) {
			if (!Character.isLetterOrDigit(tmp)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {

		return ValidationMessageType.INVALID_CHARACTER;
	}

}
