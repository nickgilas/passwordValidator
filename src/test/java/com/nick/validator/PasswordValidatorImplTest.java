package com.nick.validator;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class PasswordValidatorImplTest {

	@SuppressWarnings("unused")
	private PasswordValidatorImpl validator;

	@Before
	public void setUp() throws Exception {
		validator = new PasswordValidatorImpl();
	}

	@Test(expected = RuntimeException.class)
	public void isSupportedLocaleFail() {
		// We have to instantiate a new instance after we set the locale
		Locale currentLocale = Locale.getDefault();
		Locale.setDefault(new Locale("fr", "CA"));
		try {
			PasswordValidatorImpl.loadSystemLocale();
		} finally {
			// Change the default local back to what it was
			Locale.setDefault(currentLocale);
		}

	}

}
