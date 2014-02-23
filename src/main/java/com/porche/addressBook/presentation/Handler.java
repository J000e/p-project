package com.porche.addressbook.presentation;

import com.porche.addressbook.domain.AddressBook;

public interface Handler {

    boolean isQuitCommand();

    Handler askForParameter(Display display, Input input);

    void execute(AddressBook addressBook);

}
