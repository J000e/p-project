package com.porche.addressbook.presentation;

import java.util.HashMap;
import java.util.Map;

import com.porche.addressbook.domain.AddressBook;
import com.porche.addressbook.domain.AddressBookException;
import com.porche.addressbook.presentation.handlers.AddAddressHandler;
import com.porche.addressbook.presentation.handlers.QuitApplicationHandler;
import com.porche.addressbook.presentation.handlers.SearchAddressHandler;

public class ConsoleApplication {

    private AddressBook addressBook;
    private final Input input;
    private final Display display;
    private final InputHandler inputHandler;

    public ConsoleApplication() {
        input = new ConsoleInput();
        display = new ConsoleDisplay();
        inputHandler = new InputHandler(getInputHandlerSetup());
    }

    public ConsoleApplication withAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
        return this;
    }
    
    public void launch() {
        validateInstanceState();
        
        try {
            runTillQuit();
        } catch (AddressBookException e) {
            display.showErrorMessage(e.getMessage());
            e.printStackTrace();
        }
        input.shutDownInput();
    }

    private void validateInstanceState() {
        if (addressBook == null) {
            throw new IllegalStateException(
                    "You have to set up addressBook before launch");
        }
    }
    
    private void runTillQuit() {
        boolean shouldQuit = false;
        while (!shouldQuit) {
            display.showMenu();
            shouldQuit = inputHandler.executeCommand(display, input, addressBook);
        }
    }
    
    private Map<String, Handler> getInputHandlerSetup() {
        Map<String, Handler> setup = new HashMap<String, Handler>();
        setup.put("1", new AddAddressHandler());
        setup.put("2", new SearchAddressHandler());
        setup.put("3", new QuitApplicationHandler());
        
        return setup;
    }
}
