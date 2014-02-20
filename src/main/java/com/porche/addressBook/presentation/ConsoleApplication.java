package com.porche.addressBook.presentation;

import com.porche.addressBook.domain.Address;
import com.porche.addressBook.domain.AddressBook;

public class ConsoleApplication {

    private AddressBook addressBook;
    private final Input input;
    private final Display display;
    private Transformer<String, Address> stringToAddress;
    private Transformer<Address, String> addressToString;

    public ConsoleApplication() {
        input = new ConsoleInput();
        display = new ConsoleDisplay();
    }

    public void launch() {
        validateInstanceState();
        display.showMenu();
        while (!input.isQuit()) {
            Command command = input.getCommand();

            display.showMenu();
        }
    }

    public ConsoleApplication withAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
        return this;
    }

    private void validateInstanceState() {
        if (addressBook == null) {
            throw new IllegalStateException(
                    "You have to set up addressBook before launch");
        }
    }
}
