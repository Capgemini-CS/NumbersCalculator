package input;

import exceptions.InvalidInputException;

public interface InputInt {
    public int readNumber() throws InvalidInputException;
    public String getOperator();
}