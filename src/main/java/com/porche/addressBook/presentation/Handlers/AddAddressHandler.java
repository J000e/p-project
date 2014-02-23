package com.porche.addressBook.presentation.handlers;

import com.porche.addressBook.domain.Address;
import com.porche.addressBook.domain.AddressBook;
import com.porche.addressBook.presentation.Display;
import com.porche.addressBook.presentation.Handler;
import com.porche.addressBook.presentation.Input;


public class AddAddressHandler implements Handler {
    
    private String lastName;
    private String phoneNumber;
    
    @Override
    public boolean isQuitCommand() {
        return false;
    }
    
    @Override
    public Handler askForParameter(Display display, Input input) {
        display.showMessage("Please enter last name:");
        lastName = input.getValue();
        display.showMessage("Please enter phone number:");
        phoneNumber = input.getValue();
        
        return this;
    }

    @Override
    public void execute(AddressBook addressBook) {
        Address address = new Address();
        address.setLastName(lastName);
        address.setPhoneNumber(phoneNumber);
        
        addressBook.add(address);
    }

}
