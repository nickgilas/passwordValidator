package com.nick.validator;

public class ValidationUtil {

	public static boolean isLengthLessThen(int length, String val) {

		return val.length() < length;
	}

	public static boolean isLengthGreaterThen(int length, String val) {

		return val.length() > length;
	}

}
