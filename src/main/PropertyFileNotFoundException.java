package main;

public class PropertyFileNotFoundException extends Exception {

    PropertyFileNotFoundException() {
    }

    PropertyFileNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
