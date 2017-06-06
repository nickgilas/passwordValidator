package com.nick.validator.strategies;

import org.junit.Before;

import com.nick.validator.ValidationMessageType;

public class ValidateInvalidCharacterTest extends
		AbstractValidationTest<ValidateInvalidCharacter> {

	@Before
	public void setUp() throws Exception {
		super.setValidatorClass(ValidateInvalidCharacter.class);
	}

	@Override
	public void runValidatorScenerios() {
		assertValidationTrue("string contained all valid characters",
				VALID_CHARS);
		assertValidationFail("string contained invalid characters",
				CHARS_WITH_SPECIAL_CHARS);
	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {
		return ValidationMessageType.INVALID_CHARACTER;
	}

}
