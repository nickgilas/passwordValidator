package com.nick.validator.strategies;

import org.junit.Before;

import com.nick.validator.ValidationMessageType;

public class ValidateContainsCharactersTest extends
		AbstractValidationTest<ValidateContainsCharacters> {

	@Before
	public void beforeTest() {
		super.setValidatorClass(ValidateContainsCharacters.class);
	}

	@Override
	public void runValidatorScenerios() {
		assertValidationTrue("string contained all valid characters",
				VALID_CHARS);
		assertValidationFail("string contained only numbers", ALL_NUMERIC);
	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {
		return ValidationMessageType.NO_LETTER_FOUND;
	}

}
