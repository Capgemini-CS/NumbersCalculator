package org.beldiman.output;

public class ConsoleOutput implements OutputInt{

    public void outputResult(double result) {
        System.out.println("The result is: " + result);
        System.out.println("________________");
    }

}
