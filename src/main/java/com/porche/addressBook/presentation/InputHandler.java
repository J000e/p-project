package com.porche.addressBook.presentation;

import java.util.HashMap;
import java.util.Map;

import com.porche.addressBook.domain.AddressBook;

public class InputHandler {
    private Map<String, Handler> handlers;
    
    public InputHandler(Map<String, Handler> inputHandlerSetup) {
        handlers = new HashMap<String, Handler>();
        handlers.putAll(inputHandlerSetup);
    }

    public boolean executeCommand(Display display, Input input, AddressBook addressBook) {
        Handler handler = getHandler(display, input);
        handler.askForParameter(display, input).execute(addressBook);
        
        return handler.isQuitCommand();
    }

    private Handler getHandler(Display display, Input input) {
        display.showMessage("Please choose a command:");
        String value = input.getValue();
        while (! handlers.containsKey(value)) {
            display.showMessage("Command not supported, please choose from the list:");
            value = input.getValue();
        }
        
        return handlers.get(value);
    }

}
