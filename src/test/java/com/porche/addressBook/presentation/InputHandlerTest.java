package com.porche.addressBook.presentation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;

import com.porche.addressBook.domain.AddressBook;


public class InputHandlerTest {

    private static final String VALID_KEY = "key";
    private static final String INVALID_KEY = "yek";
    @Mock
    private Handler handler;
    @Mock
    private Display display;
    @Mock
    private Input input;
    @Mock
    private AddressBook addressBook;
    private InputHandler underTest;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        underTest = new InputHandler(setupHandlers());
        
        doReturn(handler).when(handler).askForParameter(display, input);
        Mockito.doNothing().when(handler).execute(addressBook);
    }
    
    @Test
    public void executeCommandWithValidInputShoudReturnWithTheHandlersIsQuitCommadValue() {
        //GIVEN
        doReturn(VALID_KEY).when(input).getValue();
        doReturn(true).when(handler).isQuitCommand();
        //WHEN
        boolean actual = underTest.executeCommand(display, input, addressBook);
        //THEN
        verify(display).showMessage(InputHandler.CHOOSE_A_COMMAND_MESSAGE);
        assertEquals(true, actual);
    }
    
    @Test
    public void executeCommandWithInvalidInputShoudShowCommandNotSupportedMessageAndReaskInput() {
        //GIVEN
        Mockito.when(input.getValue()).thenReturn(INVALID_KEY, VALID_KEY);
        doReturn(true).when(handler).isQuitCommand();
        //WHEN
        boolean actual = underTest.executeCommand(display, input, addressBook);
        //THEN
        verify(display).showMessage(InputHandler.CHOOSE_A_COMMAND_MESSAGE);
        verify(display).showMessage(InputHandler.COMMAND_NOT_SUPPORTED_MESSAGE);
        verify(input, times(2)).getValue();
        assertEquals(true, actual);
    }

    private Map<String, Handler> setupHandlers() {
        Map<String, Handler> handlers = new HashMap<String, Handler>();
        handlers.put(VALID_KEY, handler);
        return handlers;
    }

}
