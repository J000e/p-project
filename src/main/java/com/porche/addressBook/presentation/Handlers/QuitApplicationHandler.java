package com.porche.addressbook.presentation.handlers;

import com.porche.addressbook.domain.AddressBook;
import com.porche.addressbook.presentation.Display;
import com.porche.addressbook.presentation.Handler;
import com.porche.addressbook.presentation.Input;

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
