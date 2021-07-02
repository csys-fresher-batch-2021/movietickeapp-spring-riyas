package in.riyasahamed.util;

import java.time.LocalDateTime;

import in.riyasahamed.model.User;

public class Mailutil {
	
	public static String loginMailBodyGenerator(User user) {
		StringBuilder str = new StringBuilder();
		str.append("Dear  ");
		str.append(user.getName());
		str.append("\n\n");
		str.append("You Logged in Our Application\n\n");
		str.append("Login Info  : ");
		str.append(LocalDateTime.now());
		str.append("\n\n");
		str.append("If You are Not Logged in Kindly Contact the Administrator Mr.Riyas Ahamed.\n");
		str.append("He Will Help You to Reset Your Password\n");
		str.append("Admin Email : riyas21052@gmail.com\n");
		str.append("Thank You For Using Our Application\n\n");
		str.append("Hope Your Movie Journey Continues..........");
		String mailBody = str.toString();
		return mailBody;
	}

}
