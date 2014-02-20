package com.porche.addressBook.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.porche.addressBook.domain.Address;
import com.porche.addressBook.domain.AddressBook;

public class FileSystemAddressBook implements AddressBook {

    private static final String DEFAULT_FILENAME = "addressBook.dat";
    private String fileName;

    public FileSystemAddressBook() {
        fileName = setFileName();
    }

    public void add(Address address) throws IOException, ClassNotFoundException {
        OutputStream outputStream = new FileOutputStream(fileName);
        List<Address> addresses = readAddressList();
        addresses.add(address);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(address);
        oos.close();
    }

    public List<Address> find(String name) throws IOException,
            ClassNotFoundException {
        List<Address> addresses = readAddressList();
        List<Address> found = new ArrayList<Address>();
        for (Address address : addresses) {
            if (name.equals(address.getLastName())) {
                found.add(address);
            }
        }

        return found;
    }

    private List<Address> readAddressList() throws IOException,
            ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(
                fileInputStream);

        return (List<Address>) objectInputStream.readObject();
    }

    private String setFileName() {
        String fileName;
        try {
            fileName = System.getProperty("filename");
        } catch (IllegalArgumentException e) {
            fileName = DEFAULT_FILENAME;
        }
        return fileName;
    }

}
