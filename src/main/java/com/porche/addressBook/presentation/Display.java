package com.porche.addressBook.presentation;

import java.util.List;

import com.porche.addressBook.domain.Address;


public interface Display {

    /**
     * Displays the menu.
     */
    void showMenu();

    /**
     * Displays a list of addresses.
     * @param addresses List of addresses which shoud display
     */
    void showFoundAddresses(List<Address> addresses);

    /**
     * Displays an error message.
     * @param message 
     */
    void showErrorMessage(String message);

    /**
     * Displays a message to the screen.
     * @param message 
     */
    void showMessage(String message);

}
