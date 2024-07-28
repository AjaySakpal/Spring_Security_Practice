package com.ajay.practice.userdomainservice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Business")
public class BusinessDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer businessID;
	private String bName;
	private String bDescription;
	@OneToOne
	@JoinColumn(name = "user_Id")
	private UserDetails userDetails;
	@ManyToOne
	private BusinessPackage businessPackage;
	public Integer getBusinessID() {
		return businessID;
	}
	public void setBusinessID(Integer businessID) {
		this.businessID = businessID;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbDescription() {
		return bDescription;
	}
	public void setbDescription(String bDescription) {
		this.bDescription = bDescription;
	}

	public UserDetails getUserId() {
		return userDetails;
	}
	public void setUserId(UserDetails userId) {
		this.userDetails = userId;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public BusinessPackage getBusinessPackage() {
		return businessPackage;
	}
	public void setBusinessPackage(BusinessPackage businessPackage) {
		this.businessPackage = businessPackage;
	}
	
	
	
}
