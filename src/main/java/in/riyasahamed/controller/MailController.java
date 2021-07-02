package in.riyasahamed.controller;

import java.io.FileNotFoundException;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.riyasahamed.service.MailService;

@RestController
public class MailController {
	
	@Autowired
	MailService mailService;

	@PostMapping("sendMail")
	public ResponseEntity<?> sendMail(@RequestParam("body") String body, @RequestParam("sendTo") String sendTo,
			@RequestParam("subject") String subject) {
		mailService.sendMail(body, subject, sendTo);
		return new ResponseEntity<>("Sent Successfully", HttpStatus.OK);
	}

	@PostMapping("sendMail/attachment")
	public ResponseEntity<?> sendMailWithAttachment(@RequestParam("body") String body,
			@RequestParam("sendTo") String sendTo, @RequestParam("subject") String subject,
			@RequestParam("attachment") String attachment) throws MessagingException {
		try {
			mailService.sendMailWithAttachment(body, subject, sendTo, attachment);
			return new ResponseEntity<>("Sent Successfully", HttpStatus.OK);
		} catch (FileNotFoundException e) {
			return new ResponseEntity<>("File not found", HttpStatus.BAD_REQUEST);
		} catch (SendFailedException | MailSendException e) {
			return new ResponseEntity<>("Invalid Email ID", HttpStatus.BAD_REQUEST);
		}
	}


}
