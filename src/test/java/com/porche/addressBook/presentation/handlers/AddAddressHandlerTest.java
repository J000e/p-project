package com.porche.addressBook.presentation.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.porche.addressBook.domain.Address;
import com.porche.addressBook.domain.AddressBook;
import com.porche.addressBook.presentation.Display;
import com.porche.addressBook.presentation.Input;

public class AddAddressHandlerTest {

    private static final String PHONE_NUMBER_INPUT = "0690400400";
    private static final String LASTNAME_INPUT = "John Rambo";
    @Mock
    private Display display;
    @Mock
    private Input input;
    @Mock
    private AddressBook addressBook;
    private AddAddressHandler underTest;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        underTest = new AddAddressHandler();
    }

    @Test
    public void IsQuitCommandShoudReturnFalse() {
        //GIVEN
        //WHEN
        //THEN
        assertFalse(underTest.isQuitCommand());
    }

    @Test
    public void askForParametersShouldSetUpLastNameAndPhoneNumber()  {
        //GIVEN
        when(input.getValue()).thenReturn(LASTNAME_INPUT, PHONE_NUMBER_INPUT);
        //WHEN
        underTest.askForParameter(display, input);
        //THEN
        verify(display).showMessage(AddAddressHandler.ENTER_LAST_NAME_MESSAGE);
        verify(display).showMessage(AddAddressHandler.ENTER_PHONE_NUMBER_MESSAGE);
        assertEquals(LASTNAME_INPUT, underTest.getLastName());
        assertEquals(PHONE_NUMBER_INPUT, underTest.getPhoneNumber());
    }

    @Test
    public void executeShouldAddAddressToAddressBookAccordingParameters() throws Exception {
        //GIVEN
        when(input.getValue()).thenReturn(LASTNAME_INPUT, PHONE_NUMBER_INPUT);
        ArgumentCaptor<Address> captor = ArgumentCaptor.forClass(Address.class);
        //WHEN
        underTest.askForParameter(display, input);
        underTest.execute(addressBook);
        //THEN
        verify(addressBook).add(captor.capture());
        assertEquals(LASTNAME_INPUT, captor.getValue().getLastName());
        assertEquals(PHONE_NUMBER_INPUT, captor.getValue().getPhoneNumber());
    }
    
    

}
