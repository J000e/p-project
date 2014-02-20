package com.porche.addressBook.presentation;

public class Command {
    private Operation operation;
    private String parameter;

    public Command(Operation operation, String parameter) {
        this.operation = operation;
        this.parameter = parameter;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
