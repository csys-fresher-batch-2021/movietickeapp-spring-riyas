package in.riyasahamed.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.riyasahamed.dao.AdminRepository;
import in.riyasahamed.dao.UserRepository;
import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.Admin;
import in.riyasahamed.model.User;
import in.riyasahamed.validator.LoginValidator;
import in.riyasahamed.validator.UserValidator;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserValidator validator;

	@Autowired
	LoginValidator loginValidator;

	@Autowired
	AdminRepository adminRepo;

	/**
	 * This Method is used to get all user details
	 * @return list of all users
	 */
	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	/**
	 * This Method is used to tore the user details in the database
	 * @param user
	 */
	public void addUser(User user) {

		try {
			validator.isValidUser(user);
			userRepo.save(user);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

	}
	
	/**
	 * This Method is used to check whether the user is valid or not
	 * @param userName
	 * @param password
	 */
	public boolean userLogin(String userName, String password) {
			boolean valid = false;
		try {
			Optional<User> user = userRepo.findByUserNameAndPassWord(userName, password);
			loginValidator.isUserExists(user);
			valid = true;
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return valid;
	}
	
	/**
	 * This Method is used to check whether the admin is valid or not
	 * @param userName
	 * @param password
	 */
	public void adminLogin(String userName, String password) {
		try {
			Optional<Admin> admin = adminRepo.findByUserNameAndPassWord(userName, password);
			loginValidator.isValidAdmin(admin);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	/**
	 * This Method is used to get user id of the user
	 * @param userName
	 * @return userId 
	 */
	public Integer findByUserName(String userName) {
		return  userRepo.findByUserName(userName);
	}

}
