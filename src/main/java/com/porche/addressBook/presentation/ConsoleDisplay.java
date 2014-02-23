package com.porche.addressbook.presentation;

import java.util.List;

import com.porche.addressbook.domain.Address;

public class ConsoleDisplay implements Display {

    public void showMenu() {
        System.out.println("Please choose:\n1, Add address\n2, Search address\n3, Quit");
    }

    @Override
    public void askForPersonName() {
        System.out.println("\nPlease enter last name:");
        
    }

    @Override
    public void askForPhoneNumber() {
        System.out.println("\nPlease enter phone number:");
        
    }

    @Override
    public void askForCommnadNumber() {
        System.out.println("\nPlease choose a command:");
    }

    @Override
    public void showInvalidChooseMessage() {
        System.out.println("\nCommand not supported, please choose from the list:");
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

    @Override
    public void showErrorMessage(String message) {
        System.out.println(String.format("An unsolvable error raised: %s.", message));
    }

}
