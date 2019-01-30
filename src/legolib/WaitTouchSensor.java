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
import lejos.nxt.TouchSensor;

/**
 * WaitTouchSensor, used to wait the press of a touch sensor.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 4.0
 */
public class WaitTouchSensor extends WaitDigitalSensor {

    // ------------------------------------------------------------------------- Constants
    
    // ------------------------------------------------------------------------- Fields
    
    /**
     * The touch sensor.
     */
    private TouchSensor touchSensor;

    // ------------------------------------------------------------------------- Getters

    /**
     * Get the touch sensor.
     *
     * @return The touch sensor.
     */
    public TouchSensor getTouchSensor() {
        return this.touchSensor;
    }
    
    // ------------------------------------------------------------------------- Setters

    /**
     * Set the touch sensor.
     *
     * @param touchSensor The touch sensor.
     */
    public void setTouchSensor(TouchSensor touchSensor) {
        if (this.isFinished()) {
            this.touchSensor = touchSensor;
        }
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, defines the action to wait and the touch sensor.
     *
     * @param waitAction The wait action.
     * @param touchSensor The touch sensor.
     */
    public WaitTouchSensor(byte waitAction, TouchSensor touchSensor) {
        super(waitAction);
        setTouchSensor(touchSensor);
    }

    /**
     * Constructor method, defines the action to wait and the port where the 
     * touch sensor is connected.
     *
     * @param waitAction The wait action.
     * @param sensorPort The port of the touch sensor.
     */
    public WaitTouchSensor(byte waitAction, SensorPort sensorPort) {
        this(waitAction, new TouchSensor(sensorPort));
    }

    // ------------------------------------------------------------------------- Help Methods

    @Override
    public boolean isPressedButton() {
        return this.getTouchSensor().isPressed();
    }

    // ------------------------------------------------------------------------- General Methods
    
}