package com.porche.addressbook.application;

import com.porche.addressbook.persistence.FileSystemAddressBook;
import com.porche.addressbook.presentation.ConsoleApplication;

public class Application {

    public static void main(String[] args) {
        new ConsoleApplication()
            .withAddressBook(new FileSystemAddressBook())
            .launch();
    }
}
