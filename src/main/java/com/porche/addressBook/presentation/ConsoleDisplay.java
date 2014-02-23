package com.porche.addressBook.presentation;

import java.util.List;

import com.porche.addressBook.domain.Address;

public class ConsoleDisplay implements Display {

    public void showMenu() {
        System.out.println("Please choose:\n1, Add address\n2, Search address\n3, Quit");
    }
    
    @Override
    public void showMessage(String message) {
        System.out.println("\n" + message);
    }
    
    @Override
    public void showErrorMessage(String message) {
        System.out.println(String.format("An unsolvable error raised: %s.", message));
    }

    @Override
    public void showFoundAddresses(List<Address> foundAddresses) {
        if (foundAddresses.isEmpty()) {
            System.out.println("\nNo address found with the given lastName");
        } else {
            System.out.println("\nThe following address(es) found:\n");
            for (Address address : foundAddresses) {
                System.out.println(String.format("Name: %s - phone number: %s", 
                        address.getLastName(), 
                        address.getPhoneNumber()));
            }
        }
        
    }

}
