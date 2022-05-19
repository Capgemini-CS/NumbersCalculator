package org.beldiman.calculator;

import org.beldiman.calculations.Adder;
import org.beldiman.calculations.Divider;
import org.beldiman.calculations.Multiplier;
import org.beldiman.calculations.Subtracter;

public class CalculatorOperator implements OperatorInt{

    public double calculate (int firstNumber, int secondNumber, char operation) {
        switch (operation) {
            case '+':
                return new Adder().doOperation(firstNumber, secondNumber);
            case '-':
                return new Subtracter().doOperation(firstNumber, secondNumber);
            case '*':
                return new Multiplier().doOperation(firstNumber, secondNumber);
            case '/':
                if (secondNumber == 0) {
                    throw new ArithmeticException("Cannot divide by 0!");
                }
                return new Divider().doOperation(firstNumber, secondNumber);
        }
        return 0;
    }
}
