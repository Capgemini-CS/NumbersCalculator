package input;

import exceptions.InvalidInputException;

import java.util.Scanner;

public class ProcessInput implements InputInt{

    public int readNumber() throws InvalidInputException {
        System.out.println("Enter your number:");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            throw new InvalidInputException("Provided input is not a number.");

        }
        return scanner.nextInt();
    }



    public String getOperator() {
        System.out.println("Enter the operation:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}