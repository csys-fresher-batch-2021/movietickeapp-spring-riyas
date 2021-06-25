package in.riyasahamed.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.riyasahamed.exceptions.ValidationException;

public class NameValidator {
	
	private NameValidator() {
		// Default Constructor
	}
	
	/**
	 * This Method Checks the Name Whether it is Valid or Not
	 * @param name
	 */
	public static void isValidName(String name) {
		if (name == null || name.trim().equals("")) {
			throw new ValidationException("Name Cannot be Null");
		}
		String condition = "[a-zA-Z\\s*]+";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(name);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid Name");
		}
	}

}
