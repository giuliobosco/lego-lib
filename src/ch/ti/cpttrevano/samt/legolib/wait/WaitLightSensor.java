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

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

/**
 * Wait light sensor.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class WaitLightSensor extends WaitAnalogSensor {
    // ------------------------------------------------------------------------------------ Costants
    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Light sensor.
     */
    private LightSensor lightSensor;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the light sensor.
     *
     * @param lightSensor Light sensor.
     */
    public void setLightSensor(LightSensor lightSensor) {
        if (this.isFinished()) {
            this.lightSensor = lightSensor;
        }
    }

    /**
     * Get the light sensor.
     *
     * @return Light sensor.
     */
    public LightSensor getLightSensor() {
        return this.lightSensor;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the waiter with the bigger value that comparison value, the comparison value and the
     * light sensor.
     *
     * @param bigger      Bigger than comparison value.
     * @param value       Comparison value.
     * @param lightSensor Light sensor.
     */
    public WaitLightSensor(boolean bigger, byte value, LightSensor lightSensor) {
        super(bigger, value);

        this.setLightSensor(lightSensor);
    }

    /**
     * Create the waiter with the bigger value that comparison value, the comparison value and the
     * light sensor port.
     *
     * @param bigger     Bigger than comparison value.
     * @param value      Comparison value.
     * @param sensorPort Light sensor port.
     */
    public WaitLightSensor(boolean bigger, byte value, SensorPort sensorPort) {
        this(bigger, value, new LightSensor(sensorPort));
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    @Override
    public void run() {
        while (this.isFinished()) {
            try {
                if (this.isBigger()) {
                    this.setFinished(this.lightSensor.getLightValue() > this.getValue());
                } else {
                    this.setFinished(this.lightSensor.getLightValue() < this.getValue());
                }

                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {

            }
        }
    }

    // --------------------------------------------------------------------------- Static Components

}
