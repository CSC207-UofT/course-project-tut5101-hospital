package UI;

import Exceptions.InvalidInputException;

public interface Menu {
    public void activity() throws InvalidInputException;

    public void toState(String type) throws InvalidInputException;
}
