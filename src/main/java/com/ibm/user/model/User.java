package com.ibm.user.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This is a User model
 * 
 * @author SowjanyaLakkaraju
 *
 */
@Document
public class User {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String confirmPassword;
	private String email;
	private String gender;
	private String contactNumber;
	private String groupName;
	private String status;
	private Date createdDate;
	private boolean offerDisplayFlag;
	private String loanNumber;
	private String loanType;
	private String zipcode;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String firstName, String lastName, String userName, String password, String confirmPassword,
			String email, String gender, String contactNumber, String groupName, String status, Date createdDate,
			boolean offerDisplayFlag, String loanNumber, String loanType, String zipcode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.groupName = groupName;
		this.status = status;
		this.createdDate = createdDate;
		this.offerDisplayFlag = offerDisplayFlag;
		this.loanNumber = loanNumber;
		this.loanType = loanType;
		this.zipcode = zipcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isOfferDisplayFlag() {
		return offerDisplayFlag;
	}

	public void setOfferDisplayFlag(boolean offerDisplayFlag) {
		this.offerDisplayFlag = offerDisplayFlag;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", email=" + email + ", gender="
				+ gender + ", contactNumber=" + contactNumber + ", groupName=" + groupName + ", status=" + status
				+ ", createdDate=" + createdDate + ", offerDisplayFlag=" + offerDisplayFlag + ", loanNumber="
				+ loanNumber + ", loanType=" + loanType + ", zipcode=" + zipcode + "]";
	}

}
