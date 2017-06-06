package com.nick.validator.strategies;

import org.junit.Before;

import com.nick.validator.ValidationMessageType;

public class ValidateMaximumLengthTest extends
		AbstractValidationTest<ValidateMaximumLength> {

	@Before
	public void setUp() throws Exception {
		super.setValidatorClass(ValidateMaximumLength.class);
	}

	@Override
	public void runValidatorScenerios() {
		assertValidationTrue("string lenght was under max lenght",
				CHAR_LENGTH_OF_12);
		assertValidationFail("string over max lenght", CHAR_LENGTH_OF_13);
	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {
		return ValidationMessageType.STRING_TOO_LONG;
	}

}
