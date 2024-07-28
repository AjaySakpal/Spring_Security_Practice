package com.ajay.practice.userdomainservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ajay.practice.userdomainservice.entity.BusinessDetails;
import com.ajay.practice.userdomainservice.entity.UserDetails;

import java.util.List;


@Repository
public interface BusinessDetailsRepository extends JpaRepository<BusinessDetails, Integer>{
	
	@Query(value = "Select * from Business where user_Id=?",nativeQuery = true)
	public  List<BusinessDetails> findByUserId(int userId);
}
