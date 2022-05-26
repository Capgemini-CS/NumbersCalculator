package com.beldiman.calculator;

import com.beldiman.calculations.*;

public enum OperatorEnum {

    ADD ('+') {
        @Override
        public double performCalculation(int firstNumber, int secondNumber) {
            return adder.doOperation(firstNumber, secondNumber);
        }
    },
    SUBTRACT('-') {
        @Override
        public double performCalculation(int firstNumber, int secondNumber) {
            return subtracter.doOperation(firstNumber, secondNumber);
        }
    },
    MULTIPLY('*') {
        @Override
        public double performCalculation(int firstNumber, int secondNumber) {
            return multiplier.doOperation(firstNumber, secondNumber);
        }
    },
    DIVIDE('/') {
        @Override
        public double performCalculation(int firstNumber, int secondNumber) {
            return divider.doOperation(firstNumber, secondNumber);
        }
    };

    public char operand;
    OperationBase adder = new Adder();
    OperationBase subtracter = new Subtracter();
    OperationBase multiplier = new Multiplier();
    OperationBase divider = new Divider();
    OperatorEnum(char operand) {
        this.operand=operand;
    }

    public double performCalculation(int firstNumber, int secondNumber) {
        return 0;
    }

    public static OperatorEnum getOperatorEnumForOperand(final char  operand)
    {
        for (OperatorEnum o : OperatorEnum.values())
            if (o.operand == operand)
                return o;

        return null;
    }

}
