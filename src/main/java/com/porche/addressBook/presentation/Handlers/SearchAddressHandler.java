package com.porche.addressBook.presentation.Handlers;

import java.util.List;

import com.porche.addressBook.domain.Address;
import com.porche.addressBook.domain.AddressBook;
import com.porche.addressBook.presentation.Display;
import com.porche.addressBook.presentation.Handler;
import com.porche.addressBook.presentation.Input;

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
