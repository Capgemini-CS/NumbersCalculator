package com.beldiman.output;

import com.beldiman.exceptions.OutputException;

public interface OutputInt {

    public void outputResult(int firstNumber, char operand, int secondNumber, double result) throws OutputException;

}
