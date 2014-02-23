package com.porche.addressBook.presentation;

import com.porche.addressBook.domain.AddressBook;

public interface Handler {

    boolean isQuitCommand();

    Handler askForParameter(Display display, Input input);

    void execute(AddressBook addressBook);

}
