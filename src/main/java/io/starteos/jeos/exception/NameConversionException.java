package io.starteos.jeos.exception;

public class NameConversionException extends Exception {
    private String message;
    public NameConversionException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
