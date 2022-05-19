package org.beldiman.calculator;

import org.beldiman.calculations.*;

public class CalculatorOperator implements OperatorInt{

    public double calculate (int firstNumber, int secondNumber, char operation) {
        return OperatorEnum.getOperatorEnumForOperand(operation).performCalculation(firstNumber, secondNumber);

    }
}
