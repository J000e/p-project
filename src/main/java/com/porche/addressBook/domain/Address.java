package com.porche.addressBook.domain;

import java.io.Serializable;
/**
 * Address object represents the main model object in the application
 * It contains a lastname, and a phonenumber
 */
public class Address implements Serializable {
    private static final long serialVersionUID = -3955675294752437557L;
    private String lastName;
    private String phoneNumber;

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

    @Override
    public String toString() {
        return "Address [lastName=" + lastName + ", phoneNumber=" + phoneNumber
                + "]";
    }
}
