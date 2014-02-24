package com.porche.addressBook.presentation;

import java.util.List;

import com.porche.addressBook.domain.Address;

public class ConsoleDisplay implements Display {

    public static final String ADDRESS_DISPLAY_TEMPLATE = "Name: %s - phone number: %s";
    public static final String ERROR_TEMPLATE = "An unsolvable error raised: %s.";
    public static final String SEPARATOR = "---------------------------------\n";
    public static final String ADDRESSES_FOUND = "\nThe following address(es) found:\n";
    public static final String NO_ADDRESS_FOUND = "\nNo address found with the given lastName";
    public static final String MENU_CONTENT = "Please choose:\n1, Add address\n2, Search address\n3, Quit";

    public void showMenu() {
        System.out.println(MENU_CONTENT);
    }
    
    @Override
    public void showMessage(String message) {
        System.out.println("\n" + message);
    }
    
    @Override
    public void showErrorMessage(String message) {
        System.out.println(String.format(ERROR_TEMPLATE, message));
    }

    @Override
    public void showFoundAddresses(List<Address> foundAddresses) {
        if (foundAddresses.isEmpty()) {
            System.out.println(NO_ADDRESS_FOUND);
        } else {
            System.out.println(ADDRESSES_FOUND);
            for (Address address : foundAddresses) {
                System.out.println(String.format(ADDRESS_DISPLAY_TEMPLATE, 
                        address.getLastName(), 
                        address.getPhoneNumber()));
            }
            System.out.println(SEPARATOR);
        }
        
    }

}
