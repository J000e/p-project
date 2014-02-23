package com.porche.addressBook.presentation;

public interface Input {
    /**
     * Returns the users input.
     * @return the string provided by the user
     */
    String getValue();

    /**
     * Closes the input. It have to be called before the program exists.
     */
    void shutDownInput();
}
