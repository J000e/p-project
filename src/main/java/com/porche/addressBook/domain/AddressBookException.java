package com.porche.addressBook.domain;

@SuppressWarnings("serial")
public class AddressBookException extends RuntimeException {

    public AddressBookException(String message, Throwable exception) {
        super(message, exception);
    }

    
}
