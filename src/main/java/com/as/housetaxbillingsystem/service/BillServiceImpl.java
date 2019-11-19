package com.as.housetaxbillingsystem.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.as.housetaxbillingsystem.entity.Customer;
import com.as.housetaxbillingsystem.entity.MonthlyBill;
import com.as.housetaxbillingsystem.entity.PaymentReceipt;
import com.as.housetaxbillingsystem.exception.NoBillsException;
import com.as.housetaxbillingsystem.repo.BillRepo;
import com.as.housetaxbillingsystem.repo.CustomerRepo;
import com.as.housetaxbillingsystem.repo.PaymentRepo;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Autowired
	private CustomerRepo repo;

	@Autowired
	private BillRepo billRepo;

	@Autowired
	private PaymentRepo paymentRepo;

	public void generateBill(int custId, MonthlyBill monthlyBill) throws ParseException {

		Customer cu = (Customer) repo.findById(custId).get();

		double area = cu.getArea();
		String houseType = cu.getHouseType();
		String locality = cu.getLocality();
//		String propertyRegDate = cu.getPropertyRegistrationDate();
//		int mFromDb = Integer.parseInt(propertyRegDate.substring(5, 7));
//		int m = Integer.parseInt(monthlyBill.getBillDate().substring(5, 7));
//		System.out.println(mFromDb);
//		System.out.println(m);

		double houseTypeBasedPrice = CustomerServiceImpl.houseTypeBasedPrice.get(houseType);
		double localityBasedPrice = CustomerServiceImpl.localityBasedPrice.get(locality);
		double taxPerSqFeet = CustomerServiceImpl.taxPerSqFeet;

		double totalTax = houseTypeBasedPrice + localityBasedPrice + (area * taxPerSqFeet);

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());

		monthlyBill.setBillDate(date);
		monthlyBill.setBillPaid(false);
		monthlyBill.setAmount(totalTax);
		monthlyBill.setCustomer(cu);

//		

//		MonthlyBill bill = new MonthlyBill(userName, date, totalTax, false);
//
		billRepo.save(monthlyBill);
	}

	@Override
	public List<MonthlyBill> getBills(Integer customerId) {
		// TODO Auto-generated method stub
		return billRepo.findByCustomerCustId(customerId);
//		return null;
	}

	@Override
	public void savePaymentDetails(int custId,PaymentReceipt paymentReceipt) {
		// TODO Auto-generated method stub
		Customer cu = (Customer) repo.findById(custId).get();
		paymentReceipt.setCustomer(cu);
		paymentRepo.save(paymentReceipt);
		billRepo.billPaid(true, paymentReceipt.getBillNo());

	}

	@Override
	public List<PaymentReceipt> getAllTransactions(Integer customerId) {
		return paymentRepo.findByCustomerCustId(customerId);
	}

	@Override
	public double calculateFine(Integer billNo, String billPaidDate) throws ParseException {

		MonthlyBill billFromDb = billRepo.findById(billNo).get();
		System.out.println(billFromDb);
		String billGeneratedDate = null;
		if (billFromDb != null) {
			billGeneratedDate = billFromDb.getBillDate();
		}

		int diff;
		double fineToBeCollected = 0;

		Date billDate = new SimpleDateFormat("yyyy-MM-dd").parse(billGeneratedDate);
		Date PaidDate = new SimpleDateFormat("yyyy-MM-dd").parse(billPaidDate);
		System.out.println("from db   " + billDate);
		System.out.println("user date   " + billPaidDate);
		long difference = PaidDate.getTime() - billDate.getTime();
//				System.out.println(difference);
		diff = (int) (difference / (1000 * 60 * 60 * 24));

		System.out.println("Number of Days between dates: " + diff);
		if (diff > 15)
			fineToBeCollected = returnBook(diff);
		System.out
				.println("u have exceded return date by " + diff + " and fine to be collected is " + fineToBeCollected);
		return fineToBeCollected;
	}

	public double returnBook(double daysBetween) {
		double Fine = 0;

		for (int i = 16; i <= daysBetween; i++) {
			Fine += 5;
		}
		return Fine;

	}

	@Override
	public boolean checkBillForCurrentMonth(Integer customerId) throws NoBillsException {
		List<MonthlyBill> monthlyBills = new ArrayList<>();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println("Todays date  " + date);

		monthlyBills = billRepo.findByCustomerCustId(customerId);

		boolean billPresent = false;
		for (MonthlyBill monthlyBill : monthlyBills) {
			System.out.println(monthlyBill + "   " + date);
			if (monthlyBill.getBillDate().equals(date))
				billPresent = true;
			else
				billPresent = false;

		}

		return billPresent;
	}
}
