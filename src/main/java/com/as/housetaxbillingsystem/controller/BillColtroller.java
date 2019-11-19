package com.as.housetaxbillingsystem.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.as.housetaxbillingsystem.entity.MonthlyBill;
import com.as.housetaxbillingsystem.entity.PaymentReceipt;
import com.as.housetaxbillingsystem.exception.NoBillsException;
import com.as.housetaxbillingsystem.service.BillService;

/**
 * @author ameen shariff
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://ameenshariff.github.io")
public class BillColtroller {

	@Autowired
	private BillService service;

	/**
	 * @param custId
	 * @param monthlyBill
	 * @throws ParseException
	 */
	@PostMapping("/generateBill/{custId}")
	public void generateBill(@PathVariable int custId, @RequestBody MonthlyBill monthlyBill) throws ParseException {

//		System.out.println(billGen);
		service.generateBill(custId, monthlyBill);
	}

	/**
	 * @param customerId
	 * @return list of bills of a customer
	 */
	@GetMapping("/getBills/{customerId}")
	public List<MonthlyBill> getBills(@PathVariable(value = "customerId") Integer customerId) {
		return service.getBills(customerId);
	}

	/**
	 * @param custId
	 * @param paymentReceipt
	 */
	@PostMapping("/savePaymentDetails/{custId}")
	public void savePaymentDetails(@PathVariable int custId,@RequestBody PaymentReceipt paymentReceipt) {
		System.out.println(paymentReceipt);
		service.savePaymentDetails(custId,paymentReceipt);
	}

	/**
	 * @param customerId
	 * @return list of transactions for the customer
	 */
	@GetMapping("/getAllTransactions/{customerId}")
	public List<PaymentReceipt> getAllTransactions(@PathVariable Integer customerId) {
		List<PaymentReceipt> transactions = service.getAllTransactions(customerId);
		System.out.println(transactions);
		return transactions;
	}

	/**
	 * @param billNo
	 * @param payDate
	 * @return fine
	 */
	@GetMapping("calculateFine/{billNo}/{payDate}")
	public double calculateFine(@PathVariable Integer billNo, @PathVariable String payDate) {
		System.out.println(billNo + "     " + payDate);
		try {
			return service.calculateFine(billNo, payDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @param customerId
	 * @return checks if bill is generated for current month
	 * @throws NoBillsException
	 */
	@GetMapping("checkBillForCurrentMonth/{customerId}")
	public boolean checkBillForCurrentMonthByUserName(@PathVariable Integer customerId) throws NoBillsException {
		System.out.println("chech check .....");
		return service.checkBillForCurrentMonth(customerId);
	}

}
