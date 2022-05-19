package org.beldiman.validator;

import org.beldiman.exceptions.IllegalMathematicalException;
import org.beldiman.exceptions.InvalidInputException;

public class CalculatorValidator implements ValidatorInt{
    public void validateFunction (int firstNumber, int secondNumber, char operator) throws IllegalMathematicalException {

            if (operator == '/' && secondNumber == 0) {
                throw new IllegalMathematicalException("Division with zero is illegal.");
            }

        }

    public void isOperand (char input) throws InvalidInputException {
        if (input == '+' || input == '-' || input == '*' || input == '/') {
        } else {
            throw new InvalidInputException(input + " is not an accepted operand");
        }
    }
    }

