package com.porche.addressbook.presentation.handlers;

import com.porche.addressbook.domain.Address;
import com.porche.addressbook.domain.AddressBook;
import com.porche.addressbook.presentation.Display;
import com.porche.addressbook.presentation.Handler;
import com.porche.addressbook.presentation.Input;

public class AddAddressHandler implements Handler {
    
    private String lastName;
    private String phoneNumber;
    
    @Override
    public boolean isQuitCommand() {
        return false;
    }
    
    @Override
    public Handler askForParameter(Display display, Input input) {
        display.askForPersonName();
        lastName = input.getValue();
        display.askForPhoneNumber();
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
