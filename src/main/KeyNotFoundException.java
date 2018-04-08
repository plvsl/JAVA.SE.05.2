package main;

public class KeyNotFoundException extends Exception {

    KeyNotFoundException() {
    }

    KeyNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
