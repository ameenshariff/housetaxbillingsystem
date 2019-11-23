package com.as.housetaxbillingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Login {

	@Id
	@Column(length = 20)
	private String userName;
//	@Column(length = 12)
	private String password;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userName
	 * @param password
	 */
	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + "]";
	}

}
