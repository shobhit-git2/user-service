package com.ibm.user.service;

import com.ibm.user.exception.UserAlreadyExistsException;
import com.ibm.user.exception.UserNotFoundException;
import com.ibm.user.model.DisableOffer;
import com.ibm.user.model.User;

/**
 * This interface is used to handle user registration and authentication.
 * 
 * @author SowjanyaLakkaraju
 *
 */
public interface UserService {
	User authenticateUser(String userName, String password) throws UserNotFoundException;

	String registerUser(User user) throws UserAlreadyExistsException;
	

	String disableUserOffer(DisableOffer doObject) throws Exception;

}
