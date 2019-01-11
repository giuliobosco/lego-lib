/*
 * The MIT License
 *
 * Copyright 2018 giuliobosco.
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
 * WaitAnalogSensor, used for generalization of all waiting analog sensor class.
 * In the Lego Mindstorm Environment is rappresented by the orange block "Wait".
 *
 * @author giuliobosco
 * @version 1.0.1
 */
public class WaitAnalogSensor extends WaitSensor {
    // ------------------------------------------------------------------------------------ Costants

    /**
     * Analog sensor minimum value.
     */
    public static final byte SENSOR_MIN_VALUE = 0;

    /**
     * Analog sensor maximum value.
     */
    public static final byte SENSOR_MAX_VALUE = 100;

    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Bigger than comparision value.
     * If is true the requested value must be bigger than the value, other ways the requested value
     * must be smaller than the value.
     */
    private boolean bigger;

    /**
     * Comparison value.
     */
    private byte value;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the bigger than comparison value, checks that the wait is finished.
     *
     * @param bigger Bigger than comparison value.
     */
    public void setBigger(boolean bigger) {
        if (this.isFinished()) {
            this.bigger = bigger;
        }
    }

    /**
     * Get the bigger comparison than value.
     *
     * @return Bigger than comparison value.
     */
    public boolean isBigger() {
        return this.bigger;
    }

    /**
     * Set the comparison value, checks that the value is in the range of valid analog sensor and
     * that the wait is finished.
     *
     * @param value Comparison value.
     */
    public void setValue(byte value) {
        if (this.isFinished()) {
            if (value >= SENSOR_MIN_VALUE && value <= SENSOR_MAX_VALUE) {
                this.value = value;
            }
        }
    }

    /**
     * Get the comparison value.
     *
     * @return Comparison value.
     */
    public byte getValue() {
        return this.value;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the wait analog sensor, with bigger than value and comparison value.
     *
     * @param bigger Bigger than value.
     * @param value  Comparison value.
     */
    WaitAnalogSensor(boolean bigger, byte value) {
        this.setBigger(bigger);
        this.setValue(value);
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods
    // --------------------------------------------------------------------------- Static Components

}
