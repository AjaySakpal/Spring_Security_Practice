package com.ajay.practice.userdomainservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class BusinessFeatures {

	@Id
	private Integer ftId;
	private String feature;
	@ManyToMany
	@JoinTable(
			name="featuretopackagemapping",
			joinColumns = @JoinColumn(name="ftId"),
			inverseJoinColumns = @JoinColumn(name="packageId")
			)
	private List<BusinessPackage> businessPackage;
	public Integer getFtId() {
		return ftId;
	}
	public void setFtId(Integer ftId) {
		this.ftId = ftId;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public List<BusinessPackage> getBusinessPackage() {
		return businessPackage;
	}
	public void setBusinessPackage(List<BusinessPackage> businessPackage) {
		this.businessPackage = businessPackage;
	}
	
	
}
