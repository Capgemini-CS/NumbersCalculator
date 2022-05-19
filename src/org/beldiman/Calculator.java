package org.beldiman;

import org.beldiman.calculator.CalculatorOperator;
import org.beldiman.calculator.OperatorInt;
import org.beldiman.exceptions.IllegalMathematicalException;
import org.beldiman.exceptions.InvalidInputException;
import org.beldiman.exceptions.OutputException;
import org.beldiman.input.InputInt;
import org.beldiman.input.ProcessInput;
import org.beldiman.output.ConsoleOutput;
import org.beldiman.output.FileOutput;
import org.beldiman.output.OutputInt;
import org.beldiman.validator.CalculatorValidator;
import org.beldiman.validator.ValidatorInt;
import org.tinylog.Logger;

public class Calculator {
    private InputInt input = new ProcessInput();
//    private OutputInt output = new FileOutput();
    private OutputInt output = new ConsoleOutput();
    private ValidatorInt calculatorValidator = new CalculatorValidator();
    private OperatorInt calculatorOperator = new CalculatorOperator();

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
            output.outputResult(result);
        } catch (OutputException e) {
            Logger.error("Output error generated.");
            System.exit(0);
        }
        Logger.trace("Result printed.");

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        while (true) {
            calculator.doCalculate();
        }
    }

}
