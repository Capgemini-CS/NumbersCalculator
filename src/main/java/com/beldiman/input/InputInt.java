package com.beldiman.input;

import com.beldiman.exceptions.InvalidInputException;

public interface InputInt {
    public int readNumber() throws InvalidInputException;
    public String getOperator();
}