package com.as.housetaxbillingsystem.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.as.housetaxbillingsystem.entity.Admin;
import com.as.housetaxbillingsystem.entity.Customer;
import com.as.housetaxbillingsystem.entity.Login;
import com.as.housetaxbillingsystem.entity.MonthlyBill;
import com.as.housetaxbillingsystem.exception.InvalidCustomerException;
import com.as.housetaxbillingsystem.exception.NoAdminFoundException;
import com.as.housetaxbillingsystem.repo.AdminRepo;
import com.as.housetaxbillingsystem.repo.BillRepo;
import com.as.housetaxbillingsystem.service.AdminService;
import com.as.housetaxbillingsystem.service.LoginService;

/**
 * @author Ameen Shariff
 *
 */
@RestController
@CrossOrigin()
//@CrossOrigin(origins = "http://ameenshariff.github.io")
public class FirstController {

	@Autowired
	private LoginService service;

	@Autowired
	private BillRepo repo;

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminRepo adminRepo;

	/**
	 * @param bill saving bill to database
	 */
	@PostMapping("/insert")
	public void insertBill(@RequestBody MonthlyBill bill) {
		repo.save(bill);
	}

	@GetMapping("/hello")
	public void hello() {
		System.out.println("hello");
	}
	
	@PostMapping("/addAdmin")
	public void addAdmin(@RequestBody Admin admin) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12
		String encodedPassword = encoder.encode(admin.getPassword());
		System.out.println("Encoded password "+encodedPassword);
		admin.setPassword(encodedPassword);
		admin.setType("admin");
		adminRepo.save(admin);
	}

	/**
	 * @param customer
	 * @return returns true if customer is already registered
	 */
	@PostMapping("/registerCustomer")
	public boolean registerCustomer(@RequestBody Customer customer) {
		boolean custAlreadyRegistered = service.registerCustomer(customer);
		return custAlreadyRegistered;
	}

	/**
	 * @param login
	 */
	@PostMapping("/loginDetails")
	public void loginDetails(@RequestBody Login login) {
		service.login(login);
		System.out.println(login);
	}

	/**
	 * @param userName
	 * @param password
	 * @return validates login credentials
	 * @throws ParseException
	 */
	@GetMapping("/validateLogin/{userName}/{password}")
	public boolean validateLogin(@PathVariable("userName") String userName, @PathVariable("password") String password)
			throws ParseException {
		boolean valid = false;
		try {
			valid = service.validateLogin(userName, password);
			return valid;
		} catch (InvalidCustomerException e) {
		}
		return valid;
	}

	/**
	 * @param userName
	 * @return returns true if Admin is logged in
	 */
	@GetMapping("/isUser/{userName}")
	public boolean isUser(@PathVariable String userName) {
		return adminService.isUser(userName);
	}

	/**
	 * @param userName
	 * @param password
	 * @return Validates admin login
	 * @throws ParseException
	 */
	@GetMapping("/validateAdminLogin/{userName}/{password}")
	public boolean validateAdminLogin(@PathVariable("userName") String userName,
			@PathVariable("password") String password) throws ParseException {
//		billService.generateBill(userName);
		boolean valid = false;
		try {
			valid = adminService.validateAdminLogin(userName, password);
			return valid;
		} catch (NoAdminFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return valid;
	}

}
