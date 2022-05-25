package validator;

import exceptions.IllegalMathematicalException;
import exceptions.InvalidInputException;

public interface ValidatorInt {
    public void validateFunction(int i, int j, char c) throws IllegalMathematicalException;
    public  void isOperand(char c) throws InvalidInputException;

}
