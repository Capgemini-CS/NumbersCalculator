package com.beldiman.validator;

import com.beldiman.exceptions.IllegalMathematicalException;
import com.beldiman.exceptions.InvalidInputException;

public interface ValidatorInt {
    public void validateFunction(int i, int j, char c) throws IllegalMathematicalException;
    public  void isOperand(char c) throws InvalidInputException;

}
