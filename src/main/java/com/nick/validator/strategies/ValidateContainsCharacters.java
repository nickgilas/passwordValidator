package com.nick.validator.strategies;

import com.nick.validator.ValidationMessageType;

public class ValidateContainsCharacters implements ValidationStrategy {

	@Override
	public boolean validate(String value) {
		boolean containsLetter = false;
		for (Character tmp : value.toCharArray()) {
			if (Character.isLetter(tmp)) {
				containsLetter = true;
			}
		}
		return containsLetter;
	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {

		return ValidationMessageType.NO_LETTER_FOUND;

	}

}
