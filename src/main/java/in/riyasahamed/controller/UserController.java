package in.riyasahamed.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@PostMapping("register")
	public ResponseEntity<Message> addUser(@RequestBody User user) {
		userService.addUser(user);
		Message message = new Message();
		message.setInfoMessage("Successfully Registered User");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("userLogin")
	public ResponseEntity<Message> userLogin(@RequestBody User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("LOGGED_IN_USER", user.getUserName());
		userService.userLogin(user.getUserName(), user.getPassword());
		Message message = new Message();
		message.setInfoMessage("Successfully Logged In");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("adminLogin")
	public ResponseEntity<Message> adminLogin(@RequestBody Admin admin, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("LOGGED_IN_USER", admin.getUserName());
		session.setAttribute("ROLE", "ADMIN");
		userService.adminLogin(admin.getUserName(), admin.getPassword());
		Message message = new Message();
		message.setInfoMessage("Successfully Logged In");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
