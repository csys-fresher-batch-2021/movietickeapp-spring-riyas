package in.riyasahamed.exceptions;

public class ValidationException extends RuntimeException {
	
	/**
	 * This Exception is for Invalid Details
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method will rise the exception when there is any validation issues
	 * @param message
	 */
	public ValidationException(String message) {
		super(message);
	}

}