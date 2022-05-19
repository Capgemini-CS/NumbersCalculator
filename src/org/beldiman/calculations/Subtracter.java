package org.beldiman.calculations;

public class Subtracter implements OperationBase {


    @Override
    public double doOperation(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
