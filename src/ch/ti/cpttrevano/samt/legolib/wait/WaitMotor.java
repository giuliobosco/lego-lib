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

import ch.ti.cpttrevano.samt.legolib.motor.SingleMotor;

/**
 * WaitMotor, used for waiting a motor action.
 * In the Lego Mindstorm Environment is rappresented by the orange block "Wait".
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 2.0
 */
public class WaitMotor extends Wait {

    // ------------------------------------------------------------------------------------ Costants
    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Single motor.
     */
    private SingleMotor motor;

    /**
     * Comparison value.
     */
    private int value;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the single motor.
     *
     * @param motor Single motor.
     */
    public void setMotor(SingleMotor motor) {
        if (this.isFinished()) {
            this.motor = motor;
        }
    }

    /**
     * Get the single motor.
     *
     * @return Single Motor
     */
    public SingleMotor getMotor() {
        return this.motor;
    }

    /**
     * Set the comparison value.
     *
     * @param value Comparison value.
     */
    public void setValue(int value) {
        if (this.isFinished()) {
            this.value = value;
        }
    }

    /**
     * Get the comparison value.
     *
     * @return Comparison value.
     */
    public int getValue() {
        return this.value;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the wait motor with the motor and the comparison value.
     *
     * @param motor Single motor.
     * @param value Comparison value.
     */
    public WaitMotor(SingleMotor motor, int value) {
        this.setMotor(motor);
        this.setValue(value);
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    /**
     * Run the wait motor.
     */
    @Override
    public void run() {
        while (this.isFinished()) {
            try {
                int initialRotations = motor.getMotor().getTachoCount();

                while (!(initialRotations + value == motor.getMotor().getTachoCount())) {
                    Thread.sleep(WAIT_TIME);
                }

                this.setFinished(true);
            } catch (InterruptedException ignored) {

            }
        }
    }

    // --------------------------------------------------------------------------- Static Components

}
