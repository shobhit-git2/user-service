package com.ibm.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibm.user.model.User;

/**
 * This repository layer is used to handle the crud operations on user model.
 * 
 * @author SowjanyaLakkaraju
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

	@Query("{userName: ?0,password: ?1}")
	Optional<User> findByUsernameAndPassword(String userName, String password);
	
	@Query("{userName:?0}")
	Optional<User> findByUsername(String userName);
	
	@Query("{loanType: ?0,loanNumber: ?1, zipcode:?2}")
	Optional<User> findByLoanTypeAndLoanNumberAndZipCode(String loanType, String loanNumber,String zipCode);
	
}
