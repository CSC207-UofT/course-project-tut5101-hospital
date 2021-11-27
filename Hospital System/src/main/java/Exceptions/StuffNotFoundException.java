package Exceptions;


public class StuffNotFoundException extends Exception {
    /**
     * Exceptions
     * @param e
     */
    public StuffNotFoundException(String e) {
        super(e);
        System.out.println("some stuff is missing, make sure it is created.");
    }
}