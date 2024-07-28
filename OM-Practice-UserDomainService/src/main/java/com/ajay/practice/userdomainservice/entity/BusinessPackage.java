package com.ajay.practice.userdomainservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class BusinessPackage {

	@Id
	private Integer packageId;
	private String packageName;
	@OneToMany(mappedBy = "businessPackage")
	private List<BusinessDetails> businessDetails;
	@ManyToMany(mappedBy = "businessPackage")
	private List<BusinessFeatures>businessFeatures;
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public List<BusinessDetails> getBusinessDetails() {
		return businessDetails;
	}
	public void setBusinessDetails(List<BusinessDetails> businessDetails) {
		this.businessDetails = businessDetails;
	}
	public List<BusinessFeatures> getBusinessFeatures() {
		return businessFeatures;
	}
	public void setBusinessFeatures(List<BusinessFeatures> businessFeatures) {
		this.businessFeatures = businessFeatures;
	}
	
	
	
}
