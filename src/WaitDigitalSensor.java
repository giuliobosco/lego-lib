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

/**
 * WaitDigitalSensor, used to wait a digital sensor (usually buttons).
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 3.0
 */
public class WaitDigitalSensor extends WaitSensor {

    // ------------------------------------------------------------------------- Constants

    /**
     * Identifies the pressed button action.
     */
    public static final byte PRESSED = 0;

    /**
     * Identifies the released button action.
     */
    public static final byte RELEASED = 1;

    /**
     * Identifies the clicked button action (pressed and released).
     */
    public static final byte CLICKED = 2;

    // ------------------------------------------------------------------------- Fields

    /**
     * The action on the button to wait (pressed, released or clicked).
     */
    private byte waitAction;

    // ------------------------------------------------------------------------- Getters

    /**
     * Get the wait action.
     *
     * @return The comparison wait action.
     */
    public byte getWaitAction() {
        return this.waitAction;
    }
    
    // ------------------------------------------------------------------------- Setters

    /**
     * Set the comparison wait action checking that the wait action is valid and 
     * that the waiter is not running.
     *
     * @param waitAction The comparison wait action.
     */
    public void setWaitAction(byte waitAction) {
        if (this.isFinished()) {
            if (this.isWaitAction(waitAction)) {
                this.waitAction = waitAction;
            }
        }
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, creates the wait with the comparison wait action.
     *
     * @param waitAction The comparison wait action.
     */
    public WaitDigitalSensor(byte waitAction) {
        setWaitAction(waitAction);
    }

    // ------------------------------------------------------------------------- Help Methods

    /**
     * Checks that the comparison wait action is valid.
     *
     * @param waitAction The wait action to check.
     * @return True if the value is a valid action.
     */
    private boolean isWaitAction(byte waitAction) {
        if (waitAction == PRESSED || waitAction == RELEASED || waitAction == CLICKED) {
            return true;
        }
        return false;
    }

    /**
     * Pressed button, used to return true when the button is pressed.
     *
     * @return True if the button is pressed.
     */
    protected boolean isPressedButton() {
        return true;
    }
    
    /**
     * Method that wait for the pression of the button.
     * 
     * @throws InterruptedException If an interrupted exception occurred.
     */
    protected void buttonPressedAction() throws InterruptedException {
        if (!this.isPressedButton()) {
            while (!this.isPressedButton()) {
                sleep(WAIT_TIME);
            }
            this.setFinished(true);
        }
    }

    /**
     * Method that wait for the release of the button.
     * 
     * @throws InterruptedException If an interrupted exception occurred.
     */
    protected void buttonReleasedAction() throws InterruptedException {
        if (this.isPressedButton()) {
            while (this.isPressedButton()) {
                Thread.sleep(WAIT_TIME);
            }
            this.setFinished(true);
        }
    }

    /**
     * Method that wait for the click of the button (pressed and released).
     * 
     * @throws InterruptedException If an interrupted exception occurred.
     */
    protected void buttonClickedAction() throws InterruptedException {
        this.buttonPressedAction();
        this.buttonReleasedAction();
    }

    // ------------------------------------------------------------------------- General Methods
    
    @Override
    public void run() {
        while (this.isFinished()) {
            try {
                if (this.getWaitAction() == PRESSED) {
                    this.buttonPressedAction();
                } else if (this.getWaitAction() == RELEASED) {
                    this.buttonReleasedAction();
                } else if (this.getWaitAction() == CLICKED) {
                    this.buttonClickedAction();
                }
                sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }

}