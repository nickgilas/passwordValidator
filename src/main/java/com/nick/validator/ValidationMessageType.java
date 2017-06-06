package com.nick.validator;

/**
 * Holds all of the keys found in the properties files to help with strong
 * typing of message properties and helps support DRY principle (thought it's
 * not fully DRY)
 * 
 */
public enum ValidationMessageType {

    NO_DIGIT_FOUND("no.digit"),
    NO_LETTER_FOUND("no.letter"),
    INVALID_CHARACTER("invalid.char"),
    NULL_STRING("null.string"),
    STRING_TOO_SHORT("string.too.short"),
    STRING_TOO_LONG("string.too.long"),
    VALID_STRING("valid.string"),
    CONTAINS_SEQ_CHARS("string.contains.seq.chars"),
    UNKNOWN_EXCEPTION("unknown.error"),
   
    WELCOME_MESSAGE("welcome.message"),
    ANOTHER_STRING("another.string"),
    GOODBYE("goodbye"), ;

    private String propertyName;

    private ValidationMessageType(String propertyName) {

        this.propertyName = propertyName;
    }

    public static final boolean isValidationMessageSuccessful(ValidationMessageType message) {

        return VALID_STRING.equals(message);
    }

    public String getPropertyName() {

        return propertyName;
    }
}
