package com.ionn.exceptions;

public class InvalidDocumentException extends Exception{
    public InvalidDocumentException(Exception ex){
        super("Invalid catalog" , ex);
    }
    public InvalidDocumentException(String message){
        super(message);
    }

}
