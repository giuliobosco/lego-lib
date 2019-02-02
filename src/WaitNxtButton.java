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
 * WaitNxtButton, used to wait the pression of a specific button on the NXT.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 4.2 (2019-02-02)
 */
public class WaitNxtButton {

    // ------------------------------------------------------------------------- Constants
    
    // ------------------------------------------------------------------------- Fields
    
    // ------------------------------------------------------------------------- Getters
    
    // ------------------------------------------------------------------------- Setters
    
    // ------------------------------------------------------------------------- Constructors
    
    // ------------------------------------------------------------------------- Help Methods
    
    // ------------------------------------------------------------------------- General Methods
    
    /**
     * Wait when a button is pressed.
     *
     * @param button The button to wait to be pressed.
     */
    public static void button(Button button) {
        // waiting for pressing the button.
        button.waitForPress();
    }

    /**
     * Wait the pression of the button "Enter".
     */
    public static void enterButton() {
        button(Button.ENTER);
    }

    /**
     * Wait the pression of the button "Right".
     */
    public static void rightButton() {
        button(Button.RIGHT);
    }

    /**
     * Wait the pression of the button "Left".
     */
    public static void leftButton() {
        button(Button.LEFT);
    }
    
    /**
     * Wait the pression of the button "Escape".
     */
    public static void escapeButton() {
        button(Button.ESCAPE);
    }

}