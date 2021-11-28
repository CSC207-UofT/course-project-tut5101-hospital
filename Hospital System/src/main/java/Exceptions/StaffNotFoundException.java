package Exceptions;


public class StaffNotFoundException extends Exception {
    public StaffNotFoundException(String e) {
        super(e);
        System.out.println("some stuff is missing, make sure it is created.");
    }
}