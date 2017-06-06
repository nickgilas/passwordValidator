package com.nick.validator.strategies;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nick.validator.ValidationMessageType;

public class ValidateNonSequentialCharacters implements ValidationStrategy {

	protected static Logger LOG = LoggerFactory
			.getLogger(ValidateNonSequentialCharacters.class);

	@Override
	public boolean validate(String value) {

		return !doesStringContainSeqChars(value, 0);
	}

	protected boolean doesStringContainSeqChars(String string, int startIdx) {

		if (startIdx >= string.length()) {
			LOG.debug("Done - nothing matched");
			return false;
		}
		String evalStr = "";
		String compStr = "";

		for (int i = startIdx; i < string.length(); i++) {
			evalStr += string.substring(i, i + 1);
			compStr = string.substring(evalStr.length() + startIdx,
					string.length());
			LOG.debug("Eval string: ? \nComp string: ?", evalStr, compStr);
			LOG.debug("Eval string length: ? \nComp string length: ?",
					evalStr.length(), compStr.length());

			if (!StringUtils.isEmpty(compStr)) {

				if (evalStr.length() > compStr.length()) {
					LOG.debug("breaking out of lookup, moving up one position and start checking again");
					break;
				}

				if (compStr.equals(evalStr)) {
					LOG.debug("Strings are equal");
					return true;
				} else if (compStr.substring(0, evalStr.length()).equals(
						evalStr)) {
					LOG.debug("Compare substring match");
					return true;
				}
			} else {
				// No chars found
				return false;
			}
		}
		return doesStringContainSeqChars(string, 1 + startIdx);

	}

	@Override
	public ValidationMessageType getValidationMessageIfFailed() {

		return ValidationMessageType.CONTAINS_SEQ_CHARS;

	}

}
