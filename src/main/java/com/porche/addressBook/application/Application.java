package com.porche.addressBook.application;

import com.porche.addressBook.persistence.FileSystemAddressBook;
import com.porche.addressBook.presentation.ConsoleApplication;

public class Application {

    public static void main(String[] args) {
        new ConsoleApplication()
            .withAddressBook(new FileSystemAddressBook())
            .launch();
    }
}
