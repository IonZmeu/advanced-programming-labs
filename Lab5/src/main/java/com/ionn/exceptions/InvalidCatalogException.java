package com.ionn.exceptions;

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception ex){
        super("Invalid catalog" , ex);
    }
    public InvalidCatalogException(String message){
        super(message);
    }
}
