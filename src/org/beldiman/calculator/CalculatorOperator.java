package org.beldiman.calculator;

import org.beldiman.calculations.*;

public class CalculatorOperator implements OperatorInt{
//    OperationBase adder = new Adder();
//    OperationBase subtracter = new Subtracter();
//    OperationBase multiplier = new Multiplier();
//    OperationBase divider = new Divider();

    public double calculate (int firstNumber, int secondNumber, char operation) {
        return OperatorEnum.getOperatorEnumForOperand(operation).performCalculation(firstNumber, secondNumber);
//        switch (operation) {
//            case '+':
//                return adder.doOperation(firstNumber, secondNumber);
//            case '-':
//                return subtracter.doOperation(firstNumber, secondNumber);
//            case '*':
//                return multiplier.doOperation(firstNumber, secondNumber);
//            case '/':
//                if (secondNumber == 0) {
//                    throw new ArithmeticException("Cannot divide by 0!");
//                }
//                return divider.doOperation(firstNumber, secondNumber);
//        }
//        return 0;
    }
}
