package com.porche.addressBook.application.model;

public class Address {
	private String lastName;
	private String phoneNumber;
	
	public Address(String lastName, String phoneNumber) {
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
