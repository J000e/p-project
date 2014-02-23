package com.porche.addressBook.persistence;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.porche.addressBook.domain.Address;
import com.porche.addressBook.domain.AddressBook;
import com.porche.addressBook.domain.AddressBookException;

/**
 * Implementation of {@link AddressBook}. It stores data into a file.
 *
 */
public class FileSystemAddressBook implements AddressBook {

    private static final String FILENAME_PROPERTY = "filename";
    private static final String DEFAULT_FILENAME = "addressBook.dat";
    private File file;
    private boolean isNewFile = false;

    public FileSystemAddressBook() {
        file = createIfNotExists();
    }

    public void add(Address address) {
        try {
            List<Address> addresses = readAddressList();
            addresses.add(address);
            OutputStream outputStream = new FileOutputStream(file, false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(addresses);
            objectOutputStream.close();
            outputStream.close();
            isNewFile = false;
        } catch (FileNotFoundException e) {
            throw new AddressBookException("File cant been opened", e);
        } catch (IOException e) {
            throw new AddressBookException("File read or write problem occured", e);
        }
    }

    public List<Address> find(String name) {
        List<Address> addresses = readAddressList();
        List<Address> found = new ArrayList<Address>();
        for (Address address : addresses) {
            if (name.equals(address.getLastName())) {
                found.add(address);
            }
        }

        return found;
    }

    private List<Address> readAddressList() {
        List<Address> addressList = new ArrayList<Address>();        
        
        if (! isNewFile) {
            addressList = tryToReadAddresses();
        }
        return addressList;
    }
    

    private File createIfNotExists() {
        File f = new File(setFileName());
        try {
            if(!f.exists()) {
                f.createNewFile();
                isNewFile = true;
            }
        } catch (IOException e) {
            throw new AddressBookException("File read or write problem occured", e);
        } 
        return f;
    }

    private String setFileName() {
        String fileName = DEFAULT_FILENAME;
        String propertyFileName = System.getProperty(FILENAME_PROPERTY);
        if (propertyFileName != null) {
            fileName = propertyFileName;
        }
        return fileName;
    }
    
    private List<Address> tryToReadAddresses() {
        List<Address> addressList = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            addressList = (List<Address>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new AddressBookException("File cant been opened", e);
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new AddressBookException("File read or write problem occured", e);
        } catch (ClassNotFoundException e) {
            throw new AddressBookException("Input file contains invalid data", e);
        }
        return addressList;
    }

}
