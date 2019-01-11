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

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/**
 * @author giuliobosco
 * @version 1.0
 */
public class WaitUltrasonicSensor extends WaitAnalogSensor {
    // ------------------------------------------------------------------------------------ Costants
    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Ultrasonic sensor.
     */
    private UltrasonicSensor ultrasonicSensor;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the ultrasonic sensor.
     *
     * @param ultrasonicSensor Ultrasonic sensor.
     */
    public void setUltrasonicSensor(UltrasonicSensor ultrasonicSensor) {
        if (this.isFinished()) {
            this.ultrasonicSensor = ultrasonicSensor;
        }
    }

    /**
     * Get the ultrasonic sensor.
     *
     * @return Ultrasonic sensor.
     */
    public UltrasonicSensor getUltrasonicSensor() {
        return this.ultrasonicSensor;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the waiter with the bigger than value, the comparison value and the ultrasonic sensor.
     *
     * @param bigger           Bigger than comparison value.
     * @param value            Comparison value.
     * @param ultrasonicSensor Ultrasonic sensor.
     */
    public WaitUltrasonicSensor(boolean bigger, byte value, UltrasonicSensor ultrasonicSensor) {
        super(bigger, value);

        this.setUltrasonicSensor(ultrasonicSensor);
    }

    /**
     * Create the waiter with the bigger than comparison value, the comparison value and the
     * ultrasonic sensor port.
     *
     * @param bigger     Bigger than comparison value.
     * @param value      Comparison value.
     * @param sensorPort Ultrasonic sensor port.
     */
    public WaitUltrasonicSensor(boolean bigger, byte value, SensorPort sensorPort) {
        this(bigger, value, new UltrasonicSensor(sensorPort));
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    /**
     * Run the wait ultrasonic sensor.
     */
    @Override
    public void run() {
        this.setFinished(false);

        while (this.isFinished()) {
            try {
                if (this.isBigger()) {
                    this.setFinished(this.ultrasonicSensor.getDistance() > this.getValue());
                } else {
                    this.setFinished(this.ultrasonicSensor.getDistance() < this.getValue());
                }

                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {

            }
        }
    }

    /**
     * Begin the wait of the ultrasonic sensor.
     */
    @Override
    public void beginWait() {
        this.start();
    }

    // --------------------------------------------------------------------------- Static Components

}
