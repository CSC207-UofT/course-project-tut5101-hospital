package Exceptions;


public class StaffNotFoundException extends Exception {
    /**
     * Exceptions
     *
     * @param e
     */
    public StaffNotFoundException(String e) {
        super(e);
        System.out.println("This staff is missing, make sure it is created.");
    }
}