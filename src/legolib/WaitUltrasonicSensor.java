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

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/**
 * WaitUltrasonicSensor, used to wait an ultrasonic sensor.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 2.0.
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
     * Set the ultrasonic sensor.
     *
     * @param ultrasonicSensor The ultrasonic sensor.
     */
    public void setUltrasonicSensor(UltrasonicSensor ultrasonicSensor) {
        if (this.isFinished()) {
            this.ultrasonicSensor = ultrasonicSensor;
        }
    }

    /**
     * Get the ultrasonic sensor.
     *
     * @return The ultrasonic sensor.
     */
    public UltrasonicSensor getUltrasonicSensor() {
        return this.ultrasonicSensor;
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, defines the sensor, the comparison value and if it 
     * must be bigger than the value read by the sensor.
     *
     * @param bigger If is bigger than the comparison value.
     * @param checkValue The comparison value.
     * @param ultrasonicSensor The ultrasonic sensor.
     */
    public WaitUltrasonicSensor(boolean bigger, byte checkValue, UltrasonicSensor ultrasonicSensor) {
        super(bigger, checkValue);
        this.setUltrasonicSensor(ultrasonicSensor);
    }

    /**
     * Constructor method, defines the sensor port, the comparison value and if 
     * it must be bigger than the value read by the sensor.
     *
     * @param bigger If is bigger than the comparison value.
     * @param checkValue The comparison value.
     * @param sensorPort The port where the sensor is connected.
     */
    public WaitUltrasonicSensor(boolean bigger, byte checkValue, SensorPort sensorPort) {
        this(bigger, checkValue, new UltrasonicSensor(sensorPort));
    }

    // ------------------------------------------------------------------------- Help Methods
    
    // ------------------------------------------------------------------------- General Methods

    @Override
    public void run() {
        while (this.isFinished()) {
            try {
                if (this.isBigger()) {
                    this.setFinished(this.getUltrasonicSensor().getDistance() > this.getCheckValue());
                } else {
                    this.setFinished(this.getUltrasonicSensor().getDistance() < this.getCheckValue());
                }
                sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }

}