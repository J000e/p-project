package com.porche.addressbook.presentation.handlers;

import java.util.List;

import com.porche.addressbook.domain.Address;
import com.porche.addressbook.domain.AddressBook;
import com.porche.addressbook.presentation.Display;
import com.porche.addressbook.presentation.Handler;
import com.porche.addressbook.presentation.Input;

public class SearchAddressHandler implements Handler {

    private String lastName;
    private Display display;

    @Override
    public boolean isQuitCommand() {
        return false;
    }

    @Override
    public Handler askForParameter(Display display, Input input) {
        this.display = display;
        display.askForPersonName();
        lastName = input.getValue();
        
        return this;
    }

    @Override
    public void execute(AddressBook addressBook) {
        List<Address> foundAddresses = addressBook.find(lastName);
        
        display.showFoundAddresses(foundAddresses);
    }


}
