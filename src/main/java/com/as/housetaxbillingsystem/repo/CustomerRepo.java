package com.as.housetaxbillingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.housetaxbillingsystem.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Object findByUserName(String userName);
//	@Modifying
//	@Query("update MonthlyBill bill set bill.billPaid = :status where bill.billNo = :billNo")
//	int billPaid(@Param("status") Boolean status, @Param("billNo") Integer billNo);

}
