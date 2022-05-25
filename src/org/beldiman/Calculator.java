package org.beldiman;

import org.beldiman.calculator.CalculatorOperator;
import org.beldiman.calculator.OperatorInt;
import org.beldiman.exceptions.IllegalMathematicalException;
import org.beldiman.exceptions.InvalidInputException;
import org.beldiman.exceptions.OutputException;
import org.beldiman.input.InputInt;
import org.beldiman.input.ProcessInput;
import org.beldiman.output.*;
import org.beldiman.validator.CalculatorValidator;
import org.beldiman.validator.ValidatorInt;
import org.tinylog.Logger;

public class Calculator {
    private InputInt input = new ProcessInput();
//    private OutputInt output = new FileOutput();
    private OutputInt output = new DBOutput();
//    private OutputInt output = new ConsoleOutput();
    private ValidatorInt calculatorValidator = new CalculatorValidator();
    private OperatorInt calculatorOperator = new CalculatorOperator();
//    private DBOutput dbOutput = new DBOutput();

//    {
//        try {
//            dbOutput.createTables();
//        } catch (OutputException e) {
//            Logger.error("Error creating tables.");
//            System.exit(0);
//        }
//    }

    public void doCalculate() {
        int firstNumber = 0;
        try {
            firstNumber = input.readNumber();
        } catch (InvalidInputException e) {
            Logger.error("Provided first input is not a number.");
            System.exit(0);
        }

        char operation = input.getOperator().charAt(0);
        try {
            calculatorValidator.isOperand(operation);
            } catch (InvalidInputException ex) {
            Logger.error("Not a valid operand inserted");
            System.exit(0);
        }

        int secondNumber = 0;
        try {
            secondNumber = input.readNumber();
        } catch (InvalidInputException e) {
            Logger.error("Provided second input is not a number.");
            System.exit(0);

        }
        Logger.trace("Processing operation");
        try {
            calculatorValidator.validateFunction(firstNumber, secondNumber, operation);
        } catch (IllegalMathematicalException e) {
            Logger.error("Cannot divide by zero.");
//            e.printStackTrace();
            System.exit(0);
        }
        Logger.trace("Starting calculation");
        double result = calculatorOperator.calculate(firstNumber,secondNumber,operation);
        try {
            output.outputResult(firstNumber, operation, secondNumber, result);
        } catch (OutputException e) {
            Logger.error("Output error generated.");
            System.exit(0);
        }


    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        while (true) {
            calculator.doCalculate();
        }
    }

}
