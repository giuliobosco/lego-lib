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
package ch.ti.cpttrevano.samt.legolib.wait;

/**
 * WaitAnalogSensorRange, used to wait an analog sensor with range.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 2.1
 */
public class WaitAnalogSensorRange extends WaitSensor {

    // ------------------------------------------------------------------------- Constants
    
    // ------------------------------------------------------------------------- Flieds

    /**
     * Indicates if the value read by the sensor is in range 
     * (between the minimum and the maximum value).
     */
    private boolean inRange;

    /**
     * The minimum value of the range.
     */
    private byte minValue;

    /**
     * The maximum value of the range.
     */
    private byte maxValue;

    // ------------------------------------------------------------------------- Getters

    /**
     * To know if the value is in the range.
     *
     * @return The inRange value.
     */
    public boolean isInRange() {
        return this.inRange;
    }
    
    /**
     * Get the minimum value of the range.
     *
     * @return The minimum range value.
     */
    public byte getMinValue() {
        return this.minValue;
    }
    
    /**
     * Get the maximum value of the range.
     *
     * @return The maximum range value.
     */
    public byte getMaxValue() {
        return this.maxValue;
    }
    
    // ------------------------------------------------------------------------- Setters

    /**
     * Set the inRange field.
     *
     * @param inRange If is inside the range.
     */
    public void setInRange(boolean inRange) {
        if (this.isFinished()) {
            this.inRange = inRange;
        }
    }

    /**
     * Set the minimum value of the range.
     *
     * @param minValue The minimum range value.
     */
    public void setMinValue(byte minValue) {
        if (this.isFinished()) {
            this.minValue = minValue;
        }
    }

    /**
     * Set the maximum value of the range.
     *
     * @param maxValue The maximum range value.
     */
    public void setMaxValue(byte maxValue) {
        this.maxValue = maxValue;
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, creates a new wait by setting the fields inRange, 
     * minValue and maxValue.
     *
     * @param inRange If is inside the range.
     * @param minValue The minimum range value.
     * @param maxValue The maximum range value.
     */
    public WaitAnalogSensorRange(boolean inRange, byte minValue, byte maxValue) {
        setInRange(inRange);
        setMinValue(minValue);
        setMaxValue(maxValue);
    }

    // ------------------------------------------------------------------------- Help Methods
    
    // ------------------------------------------------------------------------- General Methods
    
}
