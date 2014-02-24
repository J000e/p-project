package com.porche.addressBook.presentation;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.porche.addressBook.domain.Address;


public class ConsoleDisplayTest {
    
    private static final String TEST_MESSAGE = "I'll be back";
    private static final String PHONE_NUMBER = "0690400400";
    private static final String LASTNAME = "John Rambo";
    private final ByteArrayOutputStream sysOut = new ByteArrayOutputStream();
    private ConsoleDisplay underTest;
    
    @Before
    public void setup() {
        underTest = new ConsoleDisplay();
        System.setOut(new PrintStream(sysOut));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void showMenuShouldDisplayMenuToStandardOutput() {
        //GIVEN
        //WHEN
        underTest.showMenu();
        //THEN
        assertEquals(ConsoleDisplay.MENU_CONTENT, sysOut.toString().trim());
    }

    @Test
    public void showMessageShoudDisplayMessage() {
        //GIVEN
        //WHEN
        underTest.showMessage(TEST_MESSAGE);
        //THEN
        assertEquals(TEST_MESSAGE.trim(), sysOut.toString().trim());
    }

    @Test
    public void showFoundAddressesDisplaysNoAddressInCaseOfEmptyInput() throws Exception {
        //GIVEN
        //WHEN
        underTest.showFoundAddresses(new ArrayList<Address>());
        //THEN
        assertEquals(ConsoleDisplay.NO_ADDRESS_FOUND.trim(), sysOut.toString().trim());
    }
    
    @Test
    public void showFoundAddressesDisplaysAddressesIfThereAreAny() throws Exception {
        //GIVEN
        ArrayList<Address> addresses = new ArrayList<Address>();
        Address address = new Address();
        address.setLastName(LASTNAME);
        address.setPhoneNumber(PHONE_NUMBER);
        addresses.add(address);
        //WHEN
        underTest.showFoundAddresses(addresses);
        //THEN
        String expected = ConsoleDisplay.ADDRESSES_FOUND + 
                String.format(ConsoleDisplay.ADDRESS_DISPLAY_TEMPLATE, LASTNAME, PHONE_NUMBER) +
                ConsoleDisplay.SEPARATOR;
        assertEquals(expected.replace("\n", "").replace("\r", ""), sysOut.toString().replace("\n", "").replace("\r", ""));
    }
}
