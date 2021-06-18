package in.riyasahamed.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.riyasahamed.model.Admin;
import in.riyasahamed.model.User;
import in.riyasahamed.service.UserService;
import in.riyasahamed.util.Message;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/GetAllUsersServlet")
	public Iterable<User> findAll() {
		return userService.getAllUsers();		
	}
	
	@PostMapping("/RegisterUserServlet")
	public ResponseEntity<Message> addUser(@RequestBody User user) {
		try {
			userService.addUser(user);
			Message message = new Message();
			message.setInfoMessage("Successfully Registered User");
			return new ResponseEntity<>( message, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/UserLoginServlet")
	public ResponseEntity<Message> userLogin(@RequestBody User user , HttpServletRequest request){
		try {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", user.getUserName());
			userService.userLogin(user.getUserName(), user.getPassword());
			Message message = new Message();
			message.setInfoMessage("Successfully Logged In");
			return new ResponseEntity<>( message, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/AdminLoginServlet")
	public ResponseEntity<Message> adminLogin(@RequestBody Admin admin , HttpServletRequest request){
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", admin.getUserName());
			session.setAttribute("ROLE", "ADMIN");
			userService.adminLogin(admin.getUserName(), admin.getPassword());
			Message message = new Message();
			message.setInfoMessage("Successfully Logged In");
			return new ResponseEntity<>( message, HttpStatus.OK);
		} catch (Exception e) {
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
}
