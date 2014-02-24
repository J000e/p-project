package com.porche.addressBook.presentation;

import java.util.HashMap;
import java.util.Map;

import com.porche.addressBook.domain.AddressBook;
import com.porche.addressBook.domain.AddressBookException;
import com.porche.addressBook.presentation.handlers.AddAddressHandler;
import com.porche.addressBook.presentation.handlers.QuitApplicationHandler;
import com.porche.addressBook.presentation.handlers.SearchAddressHandler;

/**
 * The console implementation of the addressbook application.
 */
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

    /**
     * Sets up persistence.
     * @param addressBook Persistence class. It have to implement the {@link AddressBook} interface.
     * @return The {@link ConsoleApplication} instance itself
     */
    public ConsoleApplication withAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
        return this;
    }
    
    /**
     * Launches the application.
     */
    public void launch() {
        validateInstanceState();
        
        try {
            runTillQuit();
        } catch (AddressBookException e) {
            display.showErrorMessage(e.getMessage()); //TODO Logging error messages
        }
        input.shutDownInput();
    }
    
    public AddressBook getAddressBook() {
        return addressBook;
    }

    private void validateInstanceState() {
        if (addressBook == null) {
            throw new IllegalStateException("You have to set up addressBook before launch");
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
