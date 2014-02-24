package com.porche.addressBook.presentation;

import java.util.HashMap;
import java.util.Map;

import com.porche.addressBook.domain.AddressBook;

public class InputHandler {
    public static final String COMMAND_NOT_SUPPORTED_MESSAGE = "Command not supported, please choose from the list:";
    public static final String CHOOSE_A_COMMAND_MESSAGE = "Please choose a command:";
    private Map<String, Handler> handlers;
    
    /**
     * Initialize the inputhandler object
     * @param inputHandlerSetup have to be a map with the possible inputs and the handlers linked to them
     */
    public InputHandler(Map<String, Handler> inputHandlerSetup) {
        handlers = new HashMap<String, Handler>();
        handlers.putAll(inputHandlerSetup);
    }

    /**
     * Executes the command according the users input
     * @param display the display implementation used by the application
     * @param input the input implementation used by the application
     * @param addressBook the persistence implementation used by the application
     * @return whether the user attempts to quit or not.
     */
    public boolean executeCommand(Display display, Input input, AddressBook addressBook) {
        Handler handler = getHandler(display, input);
        handler.askForParameter(display, input).execute(addressBook);
        
        return handler.isQuitCommand();
    }

    private Handler getHandler(Display display, Input input) {
        display.showMessage(CHOOSE_A_COMMAND_MESSAGE);
        String value = input.getValue();
        while (! handlers.containsKey(value)) {
            display.showMessage(COMMAND_NOT_SUPPORTED_MESSAGE);
            value = input.getValue();
        }
        
        return handlers.get(value);
    }

}
