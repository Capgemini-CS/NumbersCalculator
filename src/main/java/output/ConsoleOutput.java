package output;

public class ConsoleOutput implements OutputInt{

    public void outputResult(int firstNumber, char operand, int secondNumber, double result) {
        System.out.println("The result of " + firstNumber + " " + operand + " " + secondNumber + " is: " + result);
        System.out.println("________________");
    }

}