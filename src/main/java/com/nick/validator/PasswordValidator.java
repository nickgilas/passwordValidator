package com.nick.validator;

public interface PasswordValidator {

    /**
     * This method will validate the given input string for the following
     * criteria:
     * <ol>
     * <li>Cannot be empty
     * <li>Must be between 5 and 12 characters in length
     * <li>Must contain at least one digit and one letter
     * <li>Cannot contain any sequence of characters immediately followed by the
     * same sequence
     * </ol>
     * 
	 * @param val the string to be evaluated
	 * @return a <code>ValidationResponse</code> with 
	 * any found validation message and an boolean attribute
	 * for overall validity
	 */
    public abstract ValidationResponse isValid(String val);

}