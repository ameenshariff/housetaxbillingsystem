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
public class PaymentReceipt {
	@Id
	@SequenceGenerator(initialValue = 100, allocationSize = 1, name = "tran_no_sequence", sequenceName = "tran_no_sequence")
	@GeneratedValue(generator = "tran_no_sequence")
	private int transactionId;
	@Column(length = 30)
	private String paymentDate;
	@Column(length = 30)
	private String billGenerateDate;
	@Column(length = 30)
	private double amount;
	private String paymentNo;
	private int billNo;
	private double fine;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Customer customer;

	
	public PaymentReceipt() {
		// TODO Auto-generated constructor stub
	}


	public PaymentReceipt(int transactionId,String paymentDate, String billGenerateDate,
			double amount, String paymentNo, int billNo, double fine) {
		super();
		this.transactionId = transactionId;
		this.paymentDate = paymentDate;
		this.billGenerateDate = billGenerateDate;
		this.amount = amount;
		this.paymentNo = paymentNo;
		this.billNo = billNo;
		this.fine = fine;
	}

	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getBillGenerateDate() {
		return billGenerateDate;
	}


	public void setBillGenerateDate(String billGenerateDate) {
		this.billGenerateDate = billGenerateDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getPaymentNo() {
		return paymentNo;
	}


	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}


	public int getBillNo() {
		return billNo;
	}


	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}


	public double getFine() {
		return fine;
	}


	public void setFine(double fine) {
		this.fine = fine;
	}
	
	


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "PaymentReceipt [transactionId=" + transactionId + ", paymentDate=" + paymentDate + ", billGenerateDate="
				+ billGenerateDate + ", amount=" + amount + ", paymentNo=" + paymentNo + ", billNo=" + billNo
				+ ", fine=" + fine + ", customer=" + customer + "]";
	}


	

}
