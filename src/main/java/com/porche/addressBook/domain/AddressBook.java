package com.porche.addressBook.domain;

import java.util.List;

public interface AddressBook {
    
    /**
     * Persists an address in the store
     * @param address The {@link Address} object to persist
     */
    void add(Address address);

    /**
     * Searches for a list of {@link Address}es
     * @param name The last name of the address
     * @return A list of address. In case of no hit it returns with an empty list.
     */
    List<Address> find(String name);
}
