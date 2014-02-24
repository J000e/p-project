package com.porche.addressBook.presentation.handlers;

import com.porche.addressBook.domain.Address;
import com.porche.addressBook.domain.AddressBook;
import com.porche.addressBook.presentation.Display;
import com.porche.addressBook.presentation.Handler;
import com.porche.addressBook.presentation.Input;

/**
 * Handler implementation to handle the add action.
 */
public class AddAddressHandler implements Handler {
    
    public static final String ENTER_PHONE_NUMBER_MESSAGE = "Please enter phone number:";
    public static final String ENTER_LAST_NAME_MESSAGE = "Please enter last name:";
    private String lastName;
    private String phoneNumber;
    
    @Override
    public boolean isQuitCommand() {
        return false;
    }
    
    @Override
    public Handler askForParameter(Display display, Input input) {
        display.showMessage(ENTER_LAST_NAME_MESSAGE);
        lastName = input.getValue(); //TODO input validation may be usefull
        display.showMessage(ENTER_PHONE_NUMBER_MESSAGE);
        phoneNumber = input.getValue(); //TODO input validation may be usefull
        
        return this;
    }

    @Override
    public void execute(AddressBook addressBook) {
        Address address = new Address();
        address.setLastName(lastName);
        address.setPhoneNumber(phoneNumber);
        
        addressBook.add(address);
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
