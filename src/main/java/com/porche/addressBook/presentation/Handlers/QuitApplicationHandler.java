package com.porche.addressBook.presentation.handlers;

import com.porche.addressBook.domain.AddressBook;
import com.porche.addressBook.presentation.Display;
import com.porche.addressBook.presentation.Handler;
import com.porche.addressBook.presentation.Input;

/**
 * Handler implementation to handle the quit action.
 */
public class QuitApplicationHandler implements Handler {

    @Override
    public boolean isQuitCommand() {
        return true;
    }

    @Override
    public Handler askForParameter(Display display, Input input) {
        return this;
    }

    @Override
    public void execute(AddressBook addressBook) {
    }
}
