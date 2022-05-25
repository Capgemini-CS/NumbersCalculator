package org.beldiman.output;

import org.beldiman.exceptions.OutputException;
import org.tinylog.Logger;

import java.io.*;

public class FileOutput implements OutputInt {
    public void outputResult(int firstNumber, char operand, int secondNumber, double result) throws OutputException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("calculatorOutput.txt", true), "utf-8"))) {
            writer.write("\nThe result of the operation " + firstNumber + " " + operand + " "
                    + secondNumber + " is: " + result);
        } catch (IOException e) {
            throw new OutputException("Output to file error encountered.");
        }
        Logger.info("Result printed to file");
    }
}
