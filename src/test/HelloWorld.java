package test;

import lejos.nxt.Button;

/**
 * Test class. Prints "Hello World" on the brick.
 *
 * @author gabrialessi
 * @version 1.0 (2019-02-07)
 */
public class HelloWorld {

    /**
     * Main method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Print "Hello World".
        System.out.println("Hello World");
        // Wait for a button to end the test.
        Button.waitForAnyPress();
    }
}