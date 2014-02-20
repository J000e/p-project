package com.porche.addressBook.domain;

import java.io.IOException;
import java.util.List;

public interface AddressBook {
    void add(Address address) throws IOException, ClassNotFoundException;

    List<Address> find(String name) throws IOException, ClassNotFoundException;
}
