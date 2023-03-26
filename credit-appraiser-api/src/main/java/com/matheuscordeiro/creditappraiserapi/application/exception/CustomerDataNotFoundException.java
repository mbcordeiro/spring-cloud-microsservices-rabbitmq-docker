package com.matheuscordeiro.creditappraiserapi.application.exception;

public class CustomerDataNotFoundException extends Exception {
    public CustomerDataNotFoundException() {
        super("Customer data not found by document");
    }
}