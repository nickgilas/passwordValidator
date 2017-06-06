package com.nick.validator.strategies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nick.validator.ValidationMessageType;

public abstract class AbstractValidationTest<T extends ValidationStrategy>
		implements ValidationTestData {

	private T validator;

	public void setValidatorClass(Class<T> validatorClass) {
		try {
			validator = validatorClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getValidator() {
		return validator;
	}

	@Test
	public void testValidatorScenerios() {
		runValidatorScenerios();
	}

	public abstract void runValidatorScenerios();

	public void assertValidationTrue(String failMessage, String data) {
		assertTrue(getFailedMessage(failMessage), validator.validate(data));
	}

	public void assertValidationFail(String failMessage, String data) {
		assertFalse(getFailedMessage(failMessage), validator.validate(data));
	}

	private String getFailedMessage(String failMessage) {
		return "Validator failed [" + validator.getClass().getName()
				+ "], message: " + failMessage;
	}

	@Test
	public void testGetValidationMessageIfFailed() {

		assertEquals("Incorrect validation message found for validator: "
				+ validator.getClass(), getValidationMessageIfFailed(),
				validator.getValidationMessageIfFailed());

	}

	public abstract ValidationMessageType getValidationMessageIfFailed();
}
