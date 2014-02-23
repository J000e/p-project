package com.porche.addressbook.presentation;

import java.util.List;

import com.porche.addressbook.domain.Address;

public interface Display {

    void showMenu();

    void askForPersonName();

    void askForPhoneNumber();

    void askForCommnadNumber();

    void showInvalidChooseMessage();

    void showFoundAddresses(List<Address> find);

    void showErrorMessage(String message);

}
