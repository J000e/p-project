package com.porche.addressBook.presentation;

import java.util.Scanner;

import com.porche.addressBook.presentation.transformation.StringToOperationTransformer;

public class ConsoleInput implements Input {

    private Transformer<String, Operation> stringToOperationTransformer;
    private Scanner scanner;

    public ConsoleInput() {
        stringToOperationTransformer = new StringToOperationTransformer();
        scanner = new Scanner(System.in);
    }

    public boolean isQuit() {
        boolean isQuit = Operation.QUIT.equals(
                stringToOperationTransformer.transform(scanner.nextLine()));
        closeScanner(isQuit);
        return isQuit;
    }

    @Override
    public Command getCommand() {
        Operation operation = stringToOperationTransformer.transform(
                scanner.nextLine());
        String parameter = scanner.nextLine();
        return new Command(operation, parameter);
    }

    private void closeScanner(boolean isQuit) {
        if (isQuit) {
            scanner.close();
        }
    }

}
