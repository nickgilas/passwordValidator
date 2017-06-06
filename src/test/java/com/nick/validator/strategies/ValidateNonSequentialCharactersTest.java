package com.nick.validator.strategies;

import org.junit.Before;

import com.nick.validator.ValidationMessageType;

public class ValidateNonSequentialCharactersTest extends
		AbstractValidationTest<ValidateNonSequentialCharacters> {

	@Before
	public void setUp() throws Exception {
		super.setValidatorClass(ValidateNonSequentialCharacters.class);
	}

	@Override
	public void runValidatorScenerios() {
		assertValidationFail("string contained sequential values",
				CHARS_CONTAIL_SEQUENTIAL_VALUES);
		assertValidationTrue("string contained non-sequential values",
				CHARS_AND_NUMBERS);
		assertValidationFail("string contained more sequential values",
				CHAR_CONTAIN_MORE_SEQUENTIAL_VALUES);

		assertValidationTrue("string contained no data", EMPTY_STRING);

		assertValidationFail("string contained more sequential values",
				CHARS_SEQUENTIAL_MORE_VALUES);

	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {
		return ValidationMessageType.CONTAINS_SEQ_CHARS;
	}

}
