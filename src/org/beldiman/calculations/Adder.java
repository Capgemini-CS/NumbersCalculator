package org.beldiman.calculations;

public class Adder implements OperationBase {

    @Override
    public double doOperation(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
