package com.nick.validator.strategies;

import org.junit.Before;

import com.nick.validator.ValidationMessageType;

public class ValidateMinimumLengthTest extends
		AbstractValidationTest<ValidateMinimumLength> {

	@Before
	public void setUp() throws Exception {
		super.setValidatorClass(ValidateMinimumLength.class);
	}

	public void runValidatorScenerios() {
		assertValidationFail("string too short", CHAR_LENGTH_OF_4);
		assertValidationTrue("string lenght within range", CHAR_LENGTH_OF_5);
	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {
		return ValidationMessageType.STRING_TOO_SHORT;
	}

}
