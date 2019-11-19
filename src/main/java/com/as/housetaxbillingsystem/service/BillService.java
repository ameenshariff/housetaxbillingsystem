package com.as.housetaxbillingsystem.service;

import java.text.ParseException;
import java.util.List;

import com.as.housetaxbillingsystem.entity.MonthlyBill;
import com.as.housetaxbillingsystem.entity.PaymentReceipt;
import com.as.housetaxbillingsystem.exception.NoBillsException;

public interface BillService {
	
	void generateBill(int custId,MonthlyBill monthlyBill) throws ParseException;

	List<MonthlyBill> getBills(Integer customerId);
	
	void savePaymentDetails(int custId,PaymentReceipt paymentReceipt);

	List<PaymentReceipt> getAllTransactions(Integer customerId);
	
//	double getFine(String userName);
	
	double calculateFine(Integer billNo,String billPaidDate) throws ParseException;

	boolean checkBillForCurrentMonth(Integer customerId) throws NoBillsException;
	
}
