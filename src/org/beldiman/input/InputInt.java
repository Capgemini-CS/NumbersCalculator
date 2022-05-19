package org.beldiman.input;

import org.beldiman.exceptions.InvalidInputException;

public interface InputInt {
    public int readNumber() throws InvalidInputException;
    public String getOperator();
}
