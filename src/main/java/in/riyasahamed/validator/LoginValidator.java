package in.riyasahamed.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;

import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.Admin;
import in.riyasahamed.model.User;

@Component
public class LoginValidator {
	
	/**
	 * This Method Checks the User exists or not
	 * @param user
	 */
	public void isUserExists(Optional<User> user) {
		if(user.isEmpty()) {
			throw new ValidationException("Invalid Login Credentials");
		}
	}
	
	/**
	 * This Method checks the admin exists or not
	 * @param admin
	 */
	public void isValidAdmin(Optional<Admin> admin) {
		if(admin.isEmpty()) {
			throw new ValidationException("Invalid Login Credentials");
		}
	}

}
