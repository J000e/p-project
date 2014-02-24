package com.porche.addressBook.presentation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.porche.addressBook.domain.AddressBook;


public class ConsoleApplicationTest {

    @Mock
    private AddressBook addressBook;
    @Mock
    private InputHandler inputHandler;
    private ConsoleApplication underTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        underTest = new ConsoleApplication();
    }
    
    @Test
    public void withAddressBookShouldSetPersistence() {
        //GIVEN
        //WHEN
        underTest.withAddressBook(addressBook);
        //THEN
        assertEquals(addressBook, underTest.getAddressBook());
    }

    @Test(expected=IllegalStateException.class)
    public void launchShouldThrowExceptionWhenNoPersistenceSet() {
        //GIVEN
        //WHEN
        underTest.launch();
        //THEN exception should thrown
    }
    
    

}
