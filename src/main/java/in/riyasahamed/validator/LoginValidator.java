package in.riyasahamed.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;

import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.model.Admin;
import in.riyasahamed.model.User;

@Component
public class LoginValidator {
	
	public void isUserExists(Optional<User> user) {
		if(user.isEmpty()) {
			throw new ValidationException("Invalid Login Credentials");
		}
	}
	
	public void isValidAdmin(Optional<Admin> admin) {
		if(admin.isEmpty()) {
			throw new ValidationException("Invalid Login Credentials");
		}
	}

}
