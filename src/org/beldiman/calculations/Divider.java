package org.beldiman.calculations;

public class Divider implements OperationBase {

    @Override
    public double doOperation(int firstNumber, int secondNumber) {
        return (float)firstNumber/secondNumber;
    }
}


