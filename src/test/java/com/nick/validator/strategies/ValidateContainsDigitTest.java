package com.nick.validator.strategies;

import org.junit.Before;

import com.nick.validator.ValidationMessageType;

public class ValidateContainsDigitTest extends
		AbstractValidationTest<ValidateContainsDigit> {

	@Before
	public void beforeTest() {
		super.setValidatorClass(ValidateContainsDigit.class);
	}

	@Override
	public void runValidatorScenerios() {
		assertValidationTrue("string contained numbers", CHARS_AND_NUMBERS);
		assertValidationFail("string contained invalid digits",
				CHAR_LENGTH_OF_4);
	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {
		return ValidationMessageType.NO_DIGIT_FOUND;
	}

}
