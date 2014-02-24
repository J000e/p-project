package com.porche.addressBook.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.porche.addressBook.domain.Address;
import com.porche.addressBook.domain.AddressBookException;


public class FileSystemAddressBookTest {

    private static final String PHONE_NUMBER_INPUT = "0690400400";
    private static final String LASTNAME_INPUT = "John Rambo";
    private static final String INVALID_LAST_NAME = "Jack Slater";
    private Address testAddress;
    @Captor
    private ArgumentCaptor<List<Address>> captor;
    @Mock
    private ObjectOutputStream objectOutputStream;
    @Mock
    private FileOutputStream fileOutputStream;
    @Mock
    private ObjectInputStream objectInputStream;
    @Mock
    private FileInputStream fileInputStream;
    @Spy
    private FileSystemAddressBook underTest = new FileSystemAddressBook();
    
    @Before
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);
        mockIO();
        createTestAddress();
    }
    
    @Test(expected=AddressBookException.class)
    public void addShouldThrowExceptionWhenFileCantOpen() throws Exception {
        //GIVEN
        doThrow(new FileNotFoundException()).when(underTest).getFileInputStream();
        //WHEN
        underTest.add(testAddress);
        //THEN
    }
    
    @Test(expected=AddressBookException.class)
    public void addShouldThrowExceptionWhenThereIsAnyProblemWithTheDatafilesHeader() throws Exception {
        //GIVEN
        doThrow(new IOException()).when(underTest).getObjectInputStream(fileInputStream);
        //WHEN
        underTest.add(testAddress);
        //THEN
    }
    
    @Test(expected=AddressBookException.class)
    public void addShouldThrowExceptionWhenDatafileContainsInvalidDatas() throws Exception {
        //GIVEN
        doThrow(new ClassCastException()).when(underTest).getAddressList(objectInputStream);
        //WHEN
        underTest.add(testAddress);
        //THEN
    }
    
    @Ignore
    @Test
    public void addShouldWriteGivenAddressToTheOutput() throws Exception {
        //GIVEN
        doReturn(getEmptyAddressList()).when(underTest).getAddressList(objectInputStream);
        //WHEN
        underTest.add(testAddress);
        //THEN
        verify(underTest).writeAddressToOutputStream(captor.capture(), objectOutputStream);
        assertEquals(1, captor.capture().size());
    }

    @Test
    public void findShouldReturnWithEmptyListWhenNoMatcFound() throws Exception {
        //GIVEN
        doReturn(getListWithTestAddress()).when(underTest).getAddressList(objectInputStream);
        //WHEN
        List<Address> found = underTest.find(INVALID_LAST_NAME);
        //THEN
        assertTrue(found.isEmpty());
    }
    
    @Test
    public void findShouldReturnWithTheFoundAddress() throws Exception {
        //GIVEN
        doReturn(getListWithTestAddress()).when(underTest).getAddressList(objectInputStream);
        //WHEN
        List<Address> found = underTest.find(LASTNAME_INPUT);
        //THEN
        assertEquals(1, found.size());
    }
    
    private List<Address> getListWithTestAddress() {
        List<Address> addressList = new ArrayList<Address>();
        addressList.add(testAddress);
        
        return addressList;
    }

    private void mockIO() throws FileNotFoundException, IOException {
        doReturn(fileOutputStream).when(underTest).getFileOutputStream();
        doReturn(objectOutputStream).when(underTest).getObjectOutputStream(fileOutputStream);
        doReturn(fileInputStream).when(underTest).getFileInputStream();
        doReturn(objectInputStream).when(underTest).getObjectInputStream(fileInputStream);
        doNothing().when(objectOutputStream).close();
        doNothing().when(objectInputStream).close();
        doNothing().when(fileInputStream).close();
        doNothing().when(fileOutputStream).close();
        doNothing().when(underTest).writeAddress(Mockito.anyListOf(Address.class), Mockito.any(ObjectOutputStream.class));
    }
    
    private void createTestAddress() {
        testAddress = new Address();
        testAddress.setLastName(LASTNAME_INPUT);
        testAddress.setPhoneNumber(PHONE_NUMBER_INPUT);
    }
    
    private List<Address> getEmptyAddressList() {
        return new ArrayList<Address>();
    }
}
