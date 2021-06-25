package in.riyasahamed.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.exceptions.ValidationException;
import in.riyasahamed.util.Message;


@ControllerAdvice
public class ErrorHandler {
	
		@ExceptionHandler(ValidationException.class)
	    public ResponseEntity<Message> processValidationError(ValidationException e) {
	        Message message = new Message();
	        message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	    }
		
		@ExceptionHandler(ServiceException.class)
	    public ResponseEntity<Message> processServiceError(ServiceException e) {
	        Message message = new Message();
	        message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	    }
}
