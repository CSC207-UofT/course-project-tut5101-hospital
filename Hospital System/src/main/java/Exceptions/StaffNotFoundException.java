package Exceptions;


public class StaffNotFoundException extends Exception {
    /**
     * Exceptions
     *
     * @param e
     */
    public StaffNotFoundException(String e) {
        super(e);
        System.out.println("some stuff is missing, make sure it is created.");
    }
}