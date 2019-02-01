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

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/**
 * WaitUltrasonicSensor, used to wait a value on an ultrasonic sensor.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 3.1 (2019-02-01)
 */
public class WaitUltrasonicSensor extends WaitAnalogSensor {

    // ------------------------------------------------------------------------- Constants

    // ------------------------------------------------------------------------- Fields

    /**
     * The ultrasonic sensor.
     */
    private UltrasonicSensor ultrasonicSensor;

    // ------------------------------------------------------------------------- Getters

    /**
     * Get the ultrasonic sensor.
     *
     * @return The ultrasonic sensor.
     */
    public UltrasonicSensor getUltrasonicSensor() {
        return this.ultrasonicSensor;
    }
    
    // ------------------------------------------------------------------------- Setters
    
    /**
     * Set the ultrasonic sensor.
     *
     * @param ultrasonicSensor The ultrasonic sensor.
     */
    public void setUltrasonicSensor(UltrasonicSensor ultrasonicSensor) {
        this.ultrasonicSensor = ultrasonicSensor;
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, defines the sensor, the comparison value and if it
     * must be bigger than the value read by the sensor.
     *
     * @param ultrasonicSensor The ultrasonic sensor.
     * @param comparisonValue  The comparison value.
     * @param bigger           If is bigger than the comparison value.
     */
    public WaitUltrasonicSensor(UltrasonicSensor ultrasonicSensor, byte comparisonValue, boolean bigger) {
        super(bigger, comparisonValue);
        this.setUltrasonicSensor(ultrasonicSensor);
    }

    /**
     * Constructor method, defines the sensor port, the comparison value and if
     * it must be bigger than the value read by the sensor.
     *
     * @param sensorPort      The port where the sensor is connected.
     * @param comparisonValue The comparison value.
     * @param bigger          If is bigger than the comparison value.
     */
    public WaitUltrasonicSensor(SensorPort sensorPort, byte comparisonValue, boolean bigger) {
        this(new UltrasonicSensor(sensorPort), comparisonValue, bigger);
    }

    // ------------------------------------------------------------------------- Help Methods

    // ------------------------------------------------------------------------- General Methods

    /**
     * Main method that finishes the wait based on the comparison value.
     */
    public void waitUltrasonic() {
        boolean finished = false;
        while (!finished) {
            try {
                if (this.isBigger()) {
                    finished = this.getUltrasonicSensor().getDistance() > this.getComparisonValue();
                } else {
                    finished = this.getUltrasonicSensor().getDistance() < this.getComparisonValue();
                }
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }

}