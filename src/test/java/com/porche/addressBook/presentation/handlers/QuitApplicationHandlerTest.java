package com.porche.addressBook.presentation.handlers;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class QuitApplicationHandlerTest {
    
    private QuitApplicationHandler underTest;

    @Before
    public void setup() {
        underTest = new QuitApplicationHandler();
    }
    
    @Test
    public void IsQuitCommandShouldReturnTrue() throws Exception {
        //GIVEN
        //WHEN
        //THEN
        assertTrue(underTest.isQuitCommand());
    }

}
