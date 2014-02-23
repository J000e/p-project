package com.porche.addressbook.domain;

import java.io.Serializable;

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
