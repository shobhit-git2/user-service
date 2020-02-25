package com.ibm.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ibm.user.UserConstants;
import com.ibm.user.exception.UserAlreadyExistsException;
import com.ibm.user.exception.UserNotFoundException;
import com.ibm.user.model.DisableOffer;
import com.ibm.user.model.LoanDetails;
import com.ibm.user.model.User;
import com.ibm.user.repository.UserRepository;
import com.ibm.user.service.UserService;

/**
 * This service is used to handle user registration and authentication.
 * 
 * @author SowjanyaLakkaraju
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public String registerUser(User user) throws UserAlreadyExistsException {
		String result = null;
		user.setCreatedDate(new Date());
		user.setGroupName(UserConstants.EMPLOYEE_GROUP);
		Optional<User> optional = userRepo.findByUsername(user.getUserName());
		if (optional.isPresent()) {
			throw new UserAlreadyExistsException("User Already Exists for the user name:" + user.getUserName());
		} else {
			User u = userRepo.save(user);
			if (u != null) {
				result = u.getId();
			}
		}
		return result;

	}

	@Override
	public User authenticateUser(String userName, String password) throws UserNotFoundException {
		Optional<User> optional = userRepo.findByUsernameAndPassword(userName, password);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new UserNotFoundException("Invalid Credentials!!");
		}
	}

	@Override
	public String disableUserOffer(DisableOffer doObject) throws Exception {
		List<String> loanList=new ArrayList<String>();
		if(null!=doObject && null!=doObject.getLoanDetails() && !doObject.getLoanDetails().isEmpty()) {
			for (LoanDetails det : doObject.getLoanDetails()) {
				Optional<User> optional = userRepo.findByLoanTypeAndLoanNumberAndZipCode(doObject.getLoanType(), det.getLoanNumber(), det.getZipCode());
				if (optional.isPresent()) {
					System.out.println("Present loan"+det.getLoanNumber());
					User u=optional.get();
					u.setOfferDisplayFlag(false);
					User user=userRepo.save(u);
					System.out.println("Updated succesfully"+det.getLoanNumber());
					loanList.add(det.getLoanNumber());
				} 
				else {
					System.out.println("not added loan"+det.getLoanNumber());
				}
			}
		}
		System.out.println("Loans that are updated are:"+loanList.toString());
		if(!loanList.isEmpty()) {
			return "success";
		}
		else {
			return "failure";
		}
	}


	
}
