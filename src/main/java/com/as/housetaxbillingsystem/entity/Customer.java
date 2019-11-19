package com.as.housetaxbillingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ameen Shariff
 *
 */
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	@Column(length = 30)
	private String userName;
	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(length = 10)
	private String houseNo;
	@Column(length = 20)
	private String locality;
	@Column(length = 10)
	private String plotNo;
	@Column(length = 30)
	private String houseType;
	private double area;

	private String propertyRegistrationDate;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return customer ID
	 */
	public int getCustId() {
		return custId;
	}

	/**
	 * @param custId
	 */
	public void setCustId(int custId) {
		this.custId = custId;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getPropertyRegistrationDate() {
		return propertyRegistrationDate;
	}

	public void setPropertyRegistrationDate(String propertyRegistrationDate) {
		this.propertyRegistrationDate = propertyRegistrationDate;
	}

	public Customer(int custId, String userName, String firstName, String lastName, String houseNo, String locality,
			String plotNo, String houseType, double area, String propertyRegistrationDate) {
		super();
		this.custId = custId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.houseNo = houseNo;
		this.locality = locality;
		this.plotNo = plotNo;
		this.houseType = houseType;
		this.area = area;
		this.propertyRegistrationDate = propertyRegistrationDate;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", houseNo=" + houseNo + ", locality=" + locality + ", plotNo=" + plotNo + ", houseType="
				+ houseType + ", area=" + area + ", propertyRegistrationDate=" + propertyRegistrationDate + "]";
	}

}
