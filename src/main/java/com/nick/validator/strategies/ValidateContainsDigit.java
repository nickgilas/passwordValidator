package com.nick.validator.strategies;

import com.nick.validator.ValidationMessageType;

public class ValidateContainsDigit implements ValidationStrategy {

	@Override
	public boolean validate(String value) {
		
		for (Character tmp : value.toCharArray()) {
            if (Character.isDigit(tmp)) {
                return true;            
            }             
        }
		return false;
	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {
		
		return ValidationMessageType.NO_DIGIT_FOUND;
		
	}

}
