package com.porche.addressBook.presentation;

import com.porche.addressBook.domain.AddressBook;

public interface Handler {

    /**
     * Should be true when the input commands attempt is to quit from the application
     * @return a boolean which have to be true in case of attempt to quit and false otherwise
     */
    boolean isQuitCommand();

    /**
     * The handler asks the users to enter the informations to be able to fulfill the actual action
     * @param display the display implementation
     * @param input the input implementation
     * @return the handler instance.
     */
    Handler askForParameter(Display display, Input input);

    /**
     * Executes the choosen action.
     * @param addressBook the persistence have to provided in order to be able to store, or to find the domain object.
     */
    void execute(AddressBook addressBook);

}
