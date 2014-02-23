package com.porche.addressBook.domain;

@SuppressWarnings("serial")
public class AddressBookException extends RuntimeException {

    /**
     * Application level exception.
     * @param message The error message.
     * @param exception The wrapped exception.
     */
    public AddressBookException(String message, Throwable exception) {
        super(message, exception);
    }

    
}
