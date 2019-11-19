package com.as.housetaxbillingsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.as.housetaxbillingsystem.entity.PaymentReceipt;

public interface PaymentRepo extends JpaRepository<PaymentReceipt, Integer> {
	
	
	

//	@Query("select receipt from PaymentReceipt receipt where receipt.userName = :userName ")
//	List<PaymentReceipt> getAllTransactions(@Param("userName") String userName);

//	void deleteByUserName(String userName);
	List<PaymentReceipt> findByCustomerCustId(Integer customerId);

}