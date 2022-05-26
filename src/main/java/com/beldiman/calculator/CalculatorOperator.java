package com.beldiman.calculator;

public class CalculatorOperator implements OperatorInt{

    public double calculate (int firstNumber, int secondNumber, char operation) {
        return OperatorEnum.getOperatorEnumForOperand(operation).performCalculation(firstNumber, secondNumber);

    }
}
