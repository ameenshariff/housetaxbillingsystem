package com.as.housetaxbillingsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.as.housetaxbillingsystem.entity.MonthlyBill;

@Repository
public interface BillRepo extends JpaRepository<MonthlyBill, Integer> {
	
	@Modifying
	@Query("update MonthlyBill bill set bill.billPaid = :status where bill.billNo = :billNo")
	int billPaid(@Param("status") Boolean status, @Param("billNo") Integer billNo);

	List<MonthlyBill> findByCustomerCustId(Integer customerId);

}
