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

package legolib;

/**
 * WaitMotor, used to wait a motor action.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 3.0
 */
public class WaitMotor extends Wait {

    // ------------------------------------------------------------------------- Constants
    
    // ------------------------------------------------------------------------- Fields

    /**
     * The single motor.
     */
    private SingleMotor singleMotor;

    /**
     * User-defined value that is compared with the one got by the motor.
     */
    private int checkValue;

    // ------------------------------------------------------------------------- Getters
    
    /**
     * Get the single motor.
     *
     * @return The single Motor.
     */
    public SingleMotor getSingleMotor() {
        return this.singleMotor;
    }
    
    /**
     * Get the comparison value.
     *
     * @return The comparison value.
     */
    public int getCheckValue() {
        return this.checkValue;
    }
    
    // ------------------------------------------------------------------------- Setters

    /**
     * Set the single motor.
     *
     * @param singleMotor The single motor.
     */
    public void setSingleMotor(SingleMotor singleMotor) {
        if (this.isFinished()) {
            this.singleMotor = singleMotor;
        }
    }

    /**
     * Set the comparison value.
     *
     * @param checkValue The comparison value.
     */
    public void setCheckValue(int checkValue) {
        if (this.isFinished()) {
            this.checkValue = checkValue;
        }
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, creates the wait by setting the motor and the 
     * comparison value.
     *
     * @param singleMotor The single motor.
     * @param checkValue The comparison value.
     */
    public WaitMotor(SingleMotor singleMotor, int checkValue) {
        this.setSingleMotor(singleMotor);
        this.setCheckValue(checkValue);
    }

    // ------------------------------------------------------------------------- Help Methods
    
    // ------------------------------------------------------------------------- General Methods

    @Override
    public void run() {
        while (this.isFinished()) {
            try {
                int earlyRotations = this.getSingleMotor().getMotor().getTachoCount();
                while (!(earlyRotations + this.getCheckValue() == earlyRotations)) {
                    sleep(WAIT_TIME);
                }
                this.setFinished(true);
            } catch (InterruptedException ignored) {
            }
        }
    }

}