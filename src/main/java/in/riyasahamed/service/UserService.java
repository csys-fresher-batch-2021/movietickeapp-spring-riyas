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

	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}

	public void addUser(User user) {

		try {
			validator.isValidUser(user);
			userRepo.save(user);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}

	}
	
	public void userLogin(String userName ,String password) {		
		 try {
			Optional<User> user = userRepo.findByUserNameAndPassWord(userName, password);
			 loginValidator.isUserExists(user);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void  adminLogin(String userName ,String password) {		
		 try {
			Optional<Admin> admin = adminRepo.findByUserNameAndPassWord(userName, password);
			 loginValidator.isValidAdmin(admin);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
