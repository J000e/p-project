package com.porche.addressbook.domain;

import java.util.List;

public interface AddressBook {
    void add(Address address);

    List<Address> find(String name);
}
