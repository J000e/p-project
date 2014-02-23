package com.porche.addressBook.domain;

import java.util.List;

public interface AddressBook {
    void add(Address address);

    List<Address> find(String name);
}
