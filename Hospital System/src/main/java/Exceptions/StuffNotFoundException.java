package Exceptions;


public class StuffNotFoundException extends Exception {
    public StuffNotFoundException(String e) {
        super(e);
        System.out.println("some stuff is missing, make sure it is created.");
    }
}