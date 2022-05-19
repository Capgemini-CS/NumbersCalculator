package org.beldiman.validator;

import org.beldiman.exceptions.IllegalMathematicalException;
import org.beldiman.exceptions.InvalidInputException;

public interface ValidatorInt {
    public void validateFunction(int i, int j, char c) throws IllegalMathematicalException;
    public  void isOperand(char c) throws InvalidInputException;

}
