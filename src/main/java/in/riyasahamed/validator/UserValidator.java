package in.riyasahamed.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.User;
import in.riyasahamed.service.UserService;
import in.riyasahamed.util.EmailValidator;
import in.riyasahamed.util.MobileNumberValidator;
import in.riyasahamed.util.NameValidator;

@Component
public class UserValidator {

	private UserValidator() {
		//Default Constructor
	}
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator validator;
	
	/**
	 * This Method Validates the User Details
	 * @param user
	 */
	public void isValidUser(User user) {

		try {
			validator.isSameUser(user);
			NameValidator.isValidName(user.getName());
			EmailValidator.isValidEmail(user.getEmail());
			MobileNumberValidator.isValidMobileNumber(user.getMobileNumber());
			UserNameValidator.isValidUserName(user.getUserName());
			PasswordValidator.isValidPassword(user.getPassword());
		} catch (Exception e) {
			throw new ValidationException(e.getMessage());
		}
	}
	
	/**
	 * This Method checks whether the existing user is trying to register again
	 * @param user
	 */
	public  void isSameUser(User user) {
		
		Iterable<User> allUsers = userService.getAllUsers();

		for (User userObj : allUsers) {
			if (user.getEmail().equals(userObj.getEmail())) {
				throw new ValidationException("Email ID Already Registered");
			}
			if (user.getMobileNumber().equals(userObj.getMobileNumber())) {
				throw new ValidationException("Mobile Number Already Registered");
			}
			if (user.getUserName().equals(userObj.getUserName())) {
				throw new ValidationException("User Name Already Registered");
			}
		}
	}
}
