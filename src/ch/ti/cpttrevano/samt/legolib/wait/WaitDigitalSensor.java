/*
 * The MIT License
 *
 * Copyright 2018 SAMT.
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
package ch.ti.cpttrevano.samt.legolib.wait;

/**
 * WaitDigitalSensor, used to wait a digital sensor. In the Lego Mindstorm
 * Environment is rappresented by the orange block "Wait".
 *
 * @author gabrialessi
 * @version 1.1
 */
public class WaitDigitalSensor extends WaitSensor {

    // ------------------------------------------------------------------------------------ Costants

    /**
     * Button action.
     */
    public final byte PRESSED = 0;

    /**
     * Button released.
     */
    public final byte RELEASED = 1;

    /**
     * Button pressed than released.
     */
    public final byte CLICKED = 2;

    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Comparison wait action.
     */
    protected byte waitAction;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Get the comparison wait action.
     *
     * @return Comparison wait action.
     */
    public byte getWaitAction() {
        return this.waitAction;
    }

    /**
     * Set the comparison wait action.
     * Check that the wait action is valid with the isWaitAction method and that the waiter is not
     * running.
     *
     * @param waitAction Comparison wait action.
     */
    public void setWaitAction(byte waitAction) {
        if (this.isFinished()) {
            if (this.isWaitAction(waitAction)) {
                this.waitAction = waitAction;
            }
        }
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the wait digital sensor with the comparison wait action.
     *
     * @param waitAction Comparison wait action.
     */
    public WaitDigitalSensor(byte waitAction) {
        setWaitAction(waitAction);
    }

    // -------------------------------------------------------------------------------- Help Methods

    /**
     * Is wait action.
     * Check if the value is equals the pressed or released or clicked value.
     *
     * @param waitAction Wait action to check.
     * @return True if the value is a waitAction.
     */
    public boolean isWaitAction(byte waitAction) {
        if (waitAction == PRESSED || waitAction == RELEASED || waitAction == CLICKED) {
            return true;
        }
        return false;
    }

    // ----------------------------------------------------------------------------- General Methods
    // --------------------------------------------------------------------------- Static Components

}
