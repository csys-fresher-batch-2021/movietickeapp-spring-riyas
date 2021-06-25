package in.riyasahamed.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.riyasahamed.exceptions.ValidationException;

public class UserNameValidator {

	private UserNameValidator() {
		// default Constructor
	}

	/**
	 * This Method Checks the User name Whether it is Valid or Not
	 * @param userName
	 */
	public static void isValidUserName(String userName) {
		if (userName == null || userName.trim().equals("")) {
			throw new ValidationException("User Name Cannot be Null");
		}
		String condition = "[a-zA-Z0-9]{7,15}";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(userName);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid User Name");
		}
	}
}
