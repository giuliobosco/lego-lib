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
 * WaitAnalogSensor, used to generalize all analog sensor waiting classes.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 3.0 (2019-02-01)
 */
public class WaitAnalogSensor {

    // ------------------------------------------------------------------------- Constants

    /**
     * Defines the minimum value that an analog sensor can read.
     */
    public static final byte SENSOR_MIN_VALUE = 0;

    /**
     * Defines the maximum value that an analog sensor can read.
     */
    public static final byte SENSOR_MAX_VALUE = 100;

    // ------------------------------------------------------------------------- Fields

    /**
     * User-defined value that is compared with the one read by the sensor.
     */
    private byte comparisonValue;

    /**
     * If this is true, the comparison value must be bigger than the read value.
     * Otherwise the comparison value must be smaller than the read value.
     */
    private boolean bigger;

    // ------------------------------------------------------------------------- Getters

    /**
     * Get the comparison value.
     *
     * @return The comparison value.
     */
    public byte getCheckValue() {
        return this.comparisonValue;
    }

    /**
     * To know if the read value must be bigger than the comparison value.
     *
     * @return The bigger field.
     */
    public boolean isBigger() {
        return this.bigger;
    }

    // ------------------------------------------------------------------------- Setters

    /**
     * Set the comparison value, checks that the value is in the range of an
     * analog sensor.
     *
     * @param checkValue The comparison value.
     */
    public void setCheckValue(byte checkValue) {
        if (checkValue >= SENSOR_MIN_VALUE && checkValue <= SENSOR_MAX_VALUE) {
            this.comparisonValue = checkValue;
        }
    }

    /**
     * Set the bigger field.
     *
     * @param bigger If is bigger than the comparison value.
     */
    public void setBigger(boolean bigger) {
        this.bigger = bigger;
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, creates a new wait by setting the comparison value
     * and if it must be bigger than the value read by the sensor.
     *
     * @param bigger     If is bigger than the comparison value.
     * @param checkValue The comparison value.
     */
    WaitAnalogSensor(boolean bigger, byte checkValue) {
        this.setBigger(bigger);
        this.setCheckValue(checkValue);
    }

    // ------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------- General Methods

}
