package com.as.housetaxbillingsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.as.housetaxbillingsystem.HouseType;
import com.as.housetaxbillingsystem.Locality;
import com.as.housetaxbillingsystem.entity.Customer;
import com.as.housetaxbillingsystem.repo.BillRepo;
import com.as.housetaxbillingsystem.repo.CustomerRepo;
import com.as.housetaxbillingsystem.repo.LoginRepo;
import com.as.housetaxbillingsystem.repo.PaymentRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private LoginRepo loginRepo;

	@Autowired
	private BillRepo billRepo;

	@Autowired
	private PaymentRepo paymentRepo;

	static Map<String, Double> localityBasedPrice = new HashMap<>();

	static Map<String, Double> houseTypeBasedPrice = new HashMap<>();

	static final double taxPerSqFeet = 5;

	static {
		localityBasedPrice.put(Locality.Thanisandra.name(), 200.00);
		localityBasedPrice.put(Locality.HBR_Layout.name(), 350.00);
		localityBasedPrice.put(Locality.White_Field.name(), 300.00);
	}

	static {
		houseTypeBasedPrice.put(HouseType.Apartments_and_Flats.name(), 1200.00);
		houseTypeBasedPrice.put(HouseType.Farmhouses.name(), 900.00);
		houseTypeBasedPrice.put(HouseType.Penthouses.name(), 1500.00);
		houseTypeBasedPrice.put(HouseType.Villas.name(), 2000.00);
		houseTypeBasedPrice.put(HouseType.Eco_friendly_Homes.name(), 600.00);
	}

	@Override
	public Customer getCustomerDetails(String userName) {
		Customer customerFromDb = (Customer) customerRepo.findByUserName(userName);
		return customerFromDb;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer cust = new Customer(customer.getCustId(), customer.getUserName(), customer.getFirstName(),
				customer.getLastName(), customer.getHouseNo(), customer.getLocality(), customer.getPlotNo(),
				customer.getHouseType(), customer.getArea(), customer.getPropertyRegistrationDate());

		customerRepo.save(cust);

	}

	
	@Transactional
	@Override
	public void deleteCustomer(int custId) {
		Customer customerFromDb = customerRepo.findById(custId).get();
		customerRepo.deleteById(custId);
		loginRepo.deleteById(customerFromDb.getUserName());

	}

}
