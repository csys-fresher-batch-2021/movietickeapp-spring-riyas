package in.riyasahamed.service;

import java.io.File;
import java.io.FileNotFoundException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import in.riyasahamed.model.User;
import in.riyasahamed.util.Mailutil;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String body, String subject, String sendTo) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("rakaskingdracula120@gmail.com");
		message.setTo(sendTo);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		System.out.println("Mail sent successfully");
	}
	public void sendMailWithAttachment(String body, String subject, String sendTo, String attachment)
			throws MessagingException, FileNotFoundException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
		mimeMessageHelper.setTo(sendTo);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		FileSystemResource resource = new FileSystemResource(new File(attachment));
		mimeMessageHelper.addAttachment(resource.getFilename(), resource);
		mailSender.send(message);
	}
	
	public void sendLoginMail(User user) {
		String body = Mailutil.loginMailBodyGenerator(user);
		sendMail(body, "Login", user.getEmail());
		System.out.println("Mail Service- Send Login Mail");
	}
}
