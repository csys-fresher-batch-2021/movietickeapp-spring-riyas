package in.riyasahamed.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.riyasahamed.exceptions.ValidationException;

public class MobileNumberValidator {
	
	private MobileNumberValidator() {
		// Default Constructor
	}

	/**
	 * This Method Checks the Mobile Number Whether it is Valid or Not
	 * @param mobileNumber
	 */
	public static void isValidMobileNumber(Long mobileNumber) {

		if (mobileNumber == null || mobileNumber.toString().trim().equals("")) {
			throw new ValidationException("Mobile Number Cannot be Null");
		}
		String mobileNumberStr = String.valueOf(mobileNumber);
		String condition = "[6-9]{1}[0-9]{9}";
		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(mobileNumberStr);
		boolean valid = matcher.matches();
		if (!valid) {
			throw new ValidationException("Invalid Mobile Number");
		}

	}

}
