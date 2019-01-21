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
 * WaitAnalogSensor, used to generalize all analog sensor waiting classes.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 1.1
 */
public class WaitAnalogSensor extends WaitSensor {
    
    // ------------------------------------------------------------------------- Constants

    /**
     * Defines the minimum value that an analog sensor can read.
     */
    public static final byte SENSOR_MIN_VALUE = 0;

    /**
     * Defines the minimum value that an analog sensor can read.
     */
    public static final byte SENSOR_MAX_VALUE = 100;

    // ------------------------------------------------------------------------- Fields

    /**
     * Value chosen by the user that is compared with the one read by the 
     * sensor.
     */
    private byte value;
    
    /**
     * If this is true, the comparison value must be bigger than the read value.
     * Otherwise the comparison value must be smaller than the read value.
     */
    private boolean bigger;

    // ------------------------------------------------------------------------- Getters

    /**
     * Get the comparison value chosen by the user.
     *
     * @return The comparison value.
     */
    public byte getValue() {
        return this.value;
    }
    
    /**
     * To know if the read values is bigger than the comparison value.
     *
     * @return The bigger value.
     */
    public boolean isBigger() {
        return this.bigger;
    }
    
    // ------------------------------------------------------------------------- Setters
    
    /**
     * Set the comparison value, checks that the value is in the range of an
     * analog sensor and that the wait is finished.
     *
     * @param value The comparison value.
     */
    public void setValue(byte value) {
        if (this.isFinished()) {
            if (value >= SENSOR_MIN_VALUE && value <= SENSOR_MAX_VALUE) {
                this.value = value;
            }
        }
    }
    
    /**
     * Set the bigger field, checks that the wait is finished.
     *
     * @param bigger If is bigger than the comparison value.
     */
    public void setBigger(boolean bigger) {
        if (this.isFinished()) {
            this.bigger = bigger;
        }
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, creates a new wait by setting the fields bigger and
     * the comparison value.
     *
     * @param bigger If is bigger than the comparison value.
     * @param value The comparison value.
     */
    WaitAnalogSensor(boolean bigger, byte value) {
        this.setBigger(bigger);
        this.setValue(value);
    }

    // ------------------------------------------------------------------------- Help Methods
    
    // ------------------------------------------------------------------------- General Methods

}
