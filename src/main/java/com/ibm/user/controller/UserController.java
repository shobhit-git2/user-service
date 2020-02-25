
package com.ibm.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.user.UserConstants;
import com.ibm.user.exception.UserAlreadyExistsException;
import com.ibm.user.model.DisableOffer;
import com.ibm.user.model.User;
import com.ibm.user.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This rest controller handles the restful service calls for managing users.
 * 
 * @author SowjanyaLakkaraju
 *
 */
@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	private ResponseEntity responseEntity;
	private Map<String, String> map = new HashMap<>();
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "Stores the new user information to the database", tags = "Register User")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success | Created"),
			@ApiResponse(code = 401, message = "Un Authorized"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "Resource Not Found"), @ApiResponse(code = 409, message = "Conflict"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping(path = "/api/v1/user/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
			String id = userService.registerUser(user);
			if (null != id && !id.isEmpty()) {
				responseEntity = new ResponseEntity<>(UserConstants.SUCCESS, HttpStatus.CREATED);
			} else {
				responseEntity = new ResponseEntity<>(UserConstants.FAILURE, HttpStatus.CONFLICT);
			}
		} catch (UserAlreadyExistsException e) {
			logger.error("Exception occurred in registeruser usercontroller",e);
			responseEntity = new ResponseEntity<>(UserConstants.FAILURE, HttpStatus.CONFLICT);
		}

		return responseEntity;
	}

	@ApiOperation(value = "Authenticates the user credentials", tags = "Authenticate User")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success | Created"),
			@ApiResponse(code = 401, message = "Un Authorized"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "Resource Not Found"), @ApiResponse(code = 409, message = "Conflict"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping(path = "/api/v1/user/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		try {
			User u = userService.authenticateUser(username, password);
			if (null == u) {
				return new ResponseEntity<>("User is not authorized", HttpStatus.UNAUTHORIZED);
			} else {
				return new ResponseEntity<>(u, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("User is not authorized:" + e.getMessage(), HttpStatus.UNAUTHORIZED);
		}

	}
	
	@ApiOperation(value = "Disables the offer for user", tags = "Disable Offer for user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success | Created"),
			@ApiResponse(code = 401, message = "Un Authorized"), @ApiResponse(code = 403, message = "forbidden"),
			@ApiResponse(code = 404, message = "Resource Not Found"), @ApiResponse(code = 409, message = "Conflict"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping(path = "/api/v1/user/disableOffer")
	public ResponseEntity<?> disableOfferForUser(@RequestBody DisableOffer inputObj) {
		try {
			String id = userService.disableUserOffer(inputObj);
			if (null != id && !id.isEmpty()) {
				responseEntity = new ResponseEntity<>(UserConstants.SUCCESS, HttpStatus.CREATED);
			} else {
				responseEntity = new ResponseEntity<>(UserConstants.FAILURE, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			logger.error("Exception occurred in disableoffer usercontroller",e);
			responseEntity = new ResponseEntity<>(UserConstants.FAILURE, HttpStatus.CONFLICT);
		}

		return responseEntity;
	}

}
