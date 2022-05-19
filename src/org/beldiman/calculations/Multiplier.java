package org.beldiman.calculations;

public class Multiplier implements OperationBase {

    @Override
    public double doOperation(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}
