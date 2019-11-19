package com.as.housetaxbillingsystem.model;

public class BillGen {
	private String userName;
	private String billGenerateDate;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBillGenerateDate() {
		return billGenerateDate;
	}
	public void setBillGenerateDate(String billGenerateDate) {
		this.billGenerateDate = billGenerateDate;
	}
	@Override
	public String toString() {
		return "BillGen [userName=" + userName + ", billGenerateDate=" + billGenerateDate + "]";
	}
	
	
	
	

}
