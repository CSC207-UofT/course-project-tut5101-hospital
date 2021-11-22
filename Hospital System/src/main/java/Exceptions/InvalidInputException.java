package Exceptions;


public class InvalidInputException extends Exception {
    public InvalidInputException(String e) {
        super(e);
        System.out.println("check your input it is invalid.");
    }
}