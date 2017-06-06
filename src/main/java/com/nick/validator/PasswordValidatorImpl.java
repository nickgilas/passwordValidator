/**
 * 
 */
package com.nick.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nick.util.MessageHelper;
import com.nick.validator.strategies.ValidateContainsCharacters;
import com.nick.validator.strategies.ValidateContainsDigit;
import com.nick.validator.strategies.ValidateInvalidCharacter;
import com.nick.validator.strategies.ValidateMaximumLength;
import com.nick.validator.strategies.ValidateMinimumLength;
import com.nick.validator.strategies.ValidateNonSequentialCharacters;
import com.nick.validator.strategies.ValidationStrategy;

/**
 * This class is used to validate a password input string for specific criteria.
 * For details see the <code>isValid</code> method of this class.
 * 
 * URL Example: http://localhost:8080/PasswordValidator/rest/validation/password/SomePasswordToValidate
 * 
 */
@Service("passwordValidator")
public class PasswordValidatorImpl implements PasswordValidator {

	private static Logger LOG = LoggerFactory.getLogger(PasswordValidatorImpl.class);
	private static List<String> supportedLocales = new ArrayList<String>();
	private static MessageHelper messages;

	private List<ValidationStrategy> strategies;

	static {
		supportedLocales.add("en_US");
		supportedLocales.add("fr_FR");
		loadSystemLocale();
	}

	public ValidationResponse isValid(String val) {

		logMethod("isValid", val);

		ValidationResponse response = new ValidationResponse();
		List<ValidationMessageType> validationMessages = new ArrayList<ValidationMessageType>();
		try {
			if (StringUtils.isEmpty(val)) {
				validationMessages.add(ValidationMessageType.NULL_STRING);
				processValidationResponse(response, validationMessages);
				return response;
			}

			strategies = getValidationStrategies();

			for (ValidationStrategy strategy : strategies) {

				if (!strategy.validate(val)) {
					validationMessages.add(strategy
							.getValidationMessageIfFailed());
				}

			}

			processValidationResponse(response, validationMessages);

		} catch (Exception e) {
			LOG.error(
					"Error occurred during validation process: "
							+ e.getMessage(), e);
			response.setValid(false);
			response.addValidationMessage(getValidationMessage(ValidationMessageType.UNKNOWN_EXCEPTION));

		}
		return response;
	}

	public List<ValidationStrategy> getValidationStrategies() {
		List<ValidationStrategy> strategies = new ArrayList<ValidationStrategy>();

		strategies.add(new ValidateMinimumLength());
		strategies.add(new ValidateMaximumLength());
		strategies.add(new ValidateInvalidCharacter());
		strategies.add(new ValidateContainsCharacters());
		strategies.add(new ValidateContainsDigit());
		strategies.add(new ValidateNonSequentialCharacters());

		return strategies;
	}

	private void processValidationResponse(ValidationResponse response,
			List<ValidationMessageType> validationMessages) {
		// check the validation messages for results and if needed add them to
		// the response
		if (validationMessages.isEmpty()) {
			response.setValid(true);
			response.addValidationMessage(getValidationMessage(ValidationMessageType.VALID_STRING));
		} else {
			for (ValidationMessageType message : validationMessages) {
				response.addValidationMessage(getValidationMessage(message));
			}
			response.setValid(false);
		}
	}

	/**
	 * Loads the systems current locale properties if they are supported
	 */
	protected static void loadSystemLocale() {

		Locale currentLocale = Locale.getDefault();
		if (!supportedLocales.contains((currentLocale.toString()))) {
			StringBuffer msg = new StringBuffer();
			msg.append("Language locale (");
			msg.append(currentLocale);
			msg.append(") is not supported, this program currently only supportes these locales:\n");
			for (String local : supportedLocales) {
				msg.append(local + "\n");
			}
			throw new RuntimeException(msg.toString());
		} else {
			// Load the default locale
			messages = new MessageHelper("Messages", currentLocale);

		}
	}

	private String getValidationMessage(ValidationMessageType type) {

		return messages.getMessage(type.getPropertyName());
	}

	public static MessageHelper getMessages() {

		return messages;
	}

	private void logMethod(String methodName, String... vals) {
		StringBuffer buf = new StringBuffer();
		buf.append(methodName + "()");
		for (String val : vals) {
			buf.append(" [" + val + "]");
		}
		LOG.debug(buf.toString());
	}

	/**
	 * Simple command line interfaces for admin usage
	 */
	public static void main(String[] args) {

		PasswordValidator validator = new PasswordValidatorImpl();
		Scanner in = new Scanner(System.in);
		String next = "Y";
		MessageHelper messages = PasswordValidatorImpl.getMessages();

		while (next.equalsIgnoreCase("Y")) {
			System.out.println(messages.getMessage(ValidationMessageType.WELCOME_MESSAGE.getPropertyName()));
			try {
				validator.isValid(in.next());
				System.out.println(messages.getMessage(ValidationMessageType.VALID_STRING.getPropertyName()));
			} catch (Throwable e) {
				System.out.println(e.getMessage());
			}
			System.out.println(messages.getMessage(ValidationMessageType.ANOTHER_STRING.getPropertyName()));
			next = in.next();
		}
		System.out.println(messages.getMessage(ValidationMessageType.GOODBYE.getPropertyName()));
		System.exit(0);
	}
}
