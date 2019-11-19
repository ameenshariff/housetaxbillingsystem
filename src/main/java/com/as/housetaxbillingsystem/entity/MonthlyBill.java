package com.as.housetaxbillingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MonthlyBill {

	@Id
	@SequenceGenerator(initialValue = 1050, allocationSize = 1, name = "bill_no_sequence", sequenceName = "bill_no_sequence")
	@GeneratedValue(generator = "bill_no_sequence")
	private int billNo;
	@Column(length = 30)
	private String billDate;
	private Double amount;
	private boolean billPaid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Customer customer;

	public MonthlyBill() {
		// TODO Auto-generated constructor stub
	}

	public MonthlyBill(String billDate, Double amount, boolean billPaid, Customer customer) {
		this.billDate = billDate;
		this.amount = amount;
		this.billPaid = billPaid;
		this.customer = customer;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public boolean isBillPaid() {
		return billPaid;
	}

	public void setBillPaid(boolean billPaid) {
		this.billPaid = billPaid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "MonthlyBill [billNo=" + billNo + ", billDate=" + billDate + ", amount=" + amount + ", billPaid="
				+ billPaid + ", customer=" + customer + "]";
	}

}
