package com.porche.addressBook.presentation.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.porche.addressBook.domain.Address;
import com.porche.addressBook.domain.AddressBook;
import com.porche.addressBook.presentation.Display;
import com.porche.addressBook.presentation.Input;


public class SearchAddressHandlerTest {

    private static final String LASTNAME_INPUT = "John Rambo";
    @Mock
    private Display display;
    @Mock
    private Input input;
    @Mock
    private AddressBook addressBook;
    private SearchAddressHandler underTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        underTest = new SearchAddressHandler();
    }
    

    @Test
    public void IsQuitCommandShoudReturnFalse() {
        //GIVEN
        //WHEN
        //THEN
        assertFalse(underTest.isQuitCommand());
    }

    @Test
    public void askForParameterShoudSetDisplayAndLastnameAndShowLastNameMessage() {
        //GIVEN
        doReturn(LASTNAME_INPUT).when(input).getValue();
        //WHEN
        underTest.askForParameter(display, input);
        //THEN
        assertEquals(display, underTest.getDisplay());
        assertEquals(LASTNAME_INPUT, underTest.getLastName());
        Mockito.verify(display).showMessage(SearchAddressHandler.ENTER_LAST_NAME_MESSAGE);
    }

    @Test
    public void testExecute() throws Exception {
        //GIVEN
        List<Address> addresses = new ArrayList<Address>();
        ArgumentCaptor<List> captor = ArgumentCaptor.forClass(List.class);
        doReturn(LASTNAME_INPUT).when(input).getValue();
        doReturn(addresses).when(addressBook).find(LASTNAME_INPUT);
        //WHEN
        underTest.askForParameter(display, input);
        underTest.execute(addressBook);
        //THEN
        verify(display).showFoundAddresses(captor.capture());
        assertEquals(addresses, captor.getValue());
    }

}
