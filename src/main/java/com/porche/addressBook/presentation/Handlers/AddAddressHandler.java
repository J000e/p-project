package com.porche.addressBook.presentation.Handlers;

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
