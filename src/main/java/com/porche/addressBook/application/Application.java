package com.porche.addressBook.application;

import com.porche.addressBook.persistence.FileSystemAddressBook;
import com.porche.addressBook.presentation.ConsoleApplication;

/**
 * Test application for porche.
 * @author Jozsef Gulyas
 *
 */
public class Application {

    public static void main(String[] args) {
        new ConsoleApplication()
            .withAddressBook(new FileSystemAddressBook())
            .launch();
    }
}
