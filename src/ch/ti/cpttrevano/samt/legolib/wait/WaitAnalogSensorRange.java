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
 * WaitAnalogSensorRange, used to wait an analog sensor range.
 * In the Lego Mindstorm Environment is rappresented by the orange block "Wait".
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 2.0
 */
public class WaitAnalogSensorRange extends WaitSensor {

    // ------------------------------------------------------------------------------------ Costants
    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Inside range.
     * The value must be in the range in between the minimum value and the maximum value.
     */
    private boolean inRange;

    /**
     * Minimum range value
     */
    private byte minValue;

    /**
     * Maximum range value.
     */
    private byte maxValue;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Is inside range.
     *
     * @return Inside range.
     */
    public boolean isInRange() {
        return this.inRange;
    }

    /**
     * Set is inside range.
     *
     * @param inRange Inside range.
     */
    public void setInRange(boolean inRange) {
        if (this.isFinished()) {
            this.inRange = inRange;
        }
    }

    /**
     * Get the minimum range value.
     *
     * @return Minimum range value.
     */
    public byte getMinValue() {
        return this.minValue;
    }

    /**
     * Set the minimum range value.
     *
     * @param minValue Minimum range value.
     */
    public void setMinValue(byte minValue) {
        if (this.isFinished()) {
            this.minValue = minValue;
        }
    }

    /**
     * Get the maximum range value.
     *
     * @return Maximum range value.
     */
    public byte getMaxValue() {
        return this.maxValue;
    }

    /**
     * Set the maximum range value.
     *
     * @param maxValue Maximum range value.
     */
    public void setMaxValue(byte maxValue) {
        this.maxValue = maxValue;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the analog wait sensor with the inside range, minimum range value and maximum range
     * value.
     *
     * @param inRange  Inside range.
     * @param minValue Minimum range value.
     * @param maxValue Maximum range value.
     */
    public WaitAnalogSensorRange(boolean inRange, byte minValue, byte maxValue) {
        setInRange(inRange);
        setMinValue(minValue);
        setMaxValue(maxValue);
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods
    // --------------------------------------------------------------------------- Static Components
}
