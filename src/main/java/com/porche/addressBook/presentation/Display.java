package com.porche.addressBook.presentation;

import java.util.List;

import com.porche.addressBook.domain.Address;

public interface Display {

    void showMenu();

    void showFoundAddresses(List<Address> find);

    void showErrorMessage(String message);

    void showMessage(String message);

}
