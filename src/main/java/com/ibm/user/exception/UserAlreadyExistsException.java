package com.ibm.user.exception;

/**
 * Handle user already exists exception
 * 
 * @author SowjanyaLakkaraju
 *
 */
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
