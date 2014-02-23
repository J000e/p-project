package com.porche.addressbook.presentation;

import java.util.HashMap;
import java.util.Map;

import com.porche.addressbook.domain.AddressBook;

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
        display.askForCommnadNumber();
        String value = input.getValue();
        while (! handlers.containsKey(value)) {
            display.showInvalidChooseMessage();
            value = input.getValue();
        }
        
        return handlers.get(value);
    }

}
