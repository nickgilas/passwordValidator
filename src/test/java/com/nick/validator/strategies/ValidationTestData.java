package com.nick.validator.strategies;

public interface ValidationTestData {

	public static final String SINGLE_CHAR_LENGHT = "a";
	public static final String VALID_CHARS = "abcde";
	public static final String CHARS_WITH_SPECIAL_CHARS = "abc@a";
	public static final String ALL_NUMERIC = "123456";
	public static final String CHARS_AND_NUMBERS = "abcd1ef";
	public static final String EMPTY_STRING = "";
	public static final String CHAR_LENGTH_OF_4 = "abcd";
	public static final String CHAR_LENGTH_OF_5 = "abcde";
	public static final String CHAR_LENGTH_OF_12 = "abcd12345678";
	public static final String CHAR_LENGTH_OF_13 = "abcd123456789";
	public static final String JUST_RIGHT_STRING = "dkes34569d21";

	public static final String CHARS_CONTAIL_SEQUENTIAL_VALUES = "abcbc";
	public static final String CHAR_CONTAIN_MORE_SEQUENTIAL_VALUES = "abcdefghabcdefgh";
	public static final String CHARS_SEQUENTIAL_MORE_VALUES = "123456atxx78";

}
