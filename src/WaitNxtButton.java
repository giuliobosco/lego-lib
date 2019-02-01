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
 * WaitNxtButton, used to wait for a button pressing.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 * Can be used also the Button with out this.
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 3.0
 */
public class WaitNxtButton {

    /**
     * Wait a button pressed.
     *
     * @param button Button to wait to be pressed.
     */
    public void waitButton(Button button) {
        // waiting for pressing the button.
        button.waitForPress();
    }

    /**
     * Wait the enter button is pressed.
     */
    public void waitEnterButton() {
        Button.ENTER.waitForPress();
    }

    /**
     * Wait the right button pressed.
     */
    public void waitRightButton() {
        Button.RIGHT.waitForPress();
    }

    /**
     * Wait the left button pressed.
     */
    public void waitLeftButton() {
        Button.LEFT.waitForPress();
    }
}
