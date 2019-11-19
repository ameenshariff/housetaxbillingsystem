package com.as.housetaxbillingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Ameen Shariff
 *
 */
@Entity
public class Admin extends Login {
	@Column(length = 10)
	private String type;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param type
	 */
	public Admin(String type) {
		this.type = type;
	}
	
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Admin [type=" + type + ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
		

}
