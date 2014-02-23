package com.porche.addressBook.presentation;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner;

    public ConsoleInput() {
        scanner = new Scanner(System.in);
    }
    
    @Override
    public void shutDownInput() {
        scanner.close();
    }

    @Override
    public String getValue() {
        return scanner.nextLine();
    }

}
