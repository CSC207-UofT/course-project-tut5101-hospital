package UI;

import Exceptions.InvalidInputException;

public interface Menu {
    void activity() throws InvalidInputException;

    void toState(String type) throws InvalidInputException;
}
