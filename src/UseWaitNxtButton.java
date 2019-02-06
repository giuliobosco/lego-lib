/*
 * The MIT License
 *
 * Copyright 2019 SAMT.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import lejos.nxt.Button;

/**
 * Example of using the WaitNxtButton class. 
 * Useful for testing all the methods: press left, enter, right and escape.
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 1.3 (2019-02-06)
 */
public class UseWaitNxtButton {

    /**
     * Main method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        // Wait for the left button.
        System.out.println("Press left button to continue");
        WaitNxtButton.leftButton();
        // Wait for the enter button.
        System.out.println("Button pressed\n\nPress enter button to continue");
        WaitNxtButton.enterButton();
        // Wait for the right button.
        System.out.println("Button pressed\n\nPress right button to continue");
        WaitNxtButton.rightButton();
        System.out.println("Button pressed\n\n");
        // Wait for the escape button.
        System.out.println("Button pressed\n\nPress escape button to continue");
        WaitNxtButton.escapeButton();
        System.out.println("Button pressed\n\n");
        // Wait for another button to end the test.
        System.out.println("Test over.");
        Button.waitForAnyPress();

    }
    
}