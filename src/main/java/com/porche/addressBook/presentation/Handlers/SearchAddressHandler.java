package com.porche.addressBook.presentation.handlers;

import java.util.List;

import com.porche.addressBook.domain.Address;
import com.porche.addressBook.domain.AddressBook;
import com.porche.addressBook.presentation.Display;
import com.porche.addressBook.presentation.Handler;
import com.porche.addressBook.presentation.Input;


/**
 * Handler implementation to handle the search action.
 */
public class SearchAddressHandler implements Handler {

    public static final String ENTER_LAST_NAME_MESSAGE = "Please enter last name:";
    private String lastName;
    private Display display;

    @Override
    public boolean isQuitCommand() {
        return false;
    }

    @Override
    public Handler askForParameter(Display display, Input input) {
        this.display = display;
        display.showMessage(ENTER_LAST_NAME_MESSAGE);
        lastName = input.getValue();
        
        return this;
    }

    @Override
    public void execute(AddressBook addressBook) {
        List<Address> foundAddresses = addressBook.find(lastName);
        
        display.showFoundAddresses(foundAddresses);
    }

    public String getLastName() {
        return lastName;
    }

    public Display getDisplay() {
        return display;
    }
}
