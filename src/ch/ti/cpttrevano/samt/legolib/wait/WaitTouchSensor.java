/*
 * The MIT License
 *
 * Copyright 2018 gabrialessi.
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
import lejos.nxt.TouchSensor;

/**
 * Wait the touch sensor.
 *
 * @author gabrialessi
 * @version 2.1
 */
public class WaitTouchSensor extends WaitDigitalSensor {

    // ------------------------------------------------------------------------------------ Costants
    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Touch sensor.
     */
    private TouchSensor touchSensor;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the touch sensor.
     *
     * @param touchSensor Touch sensor.
     */
    public void setTouchSensor(TouchSensor touchSensor) {
        if (this.isFinished()) {
            this.touchSensor = touchSensor;
        }
    }

    /**
     * Get the touch sensor.
     *
     * @return Touch sensor.
     */
    public TouchSensor getTouchSensor() {
        return this.touchSensor;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the wait touch sensor with the touch sensor and the waited action.
     *
     * @param waitAction Wait action.
     * @param touchSensor Touch sensor.
     */
    public WaitTouchSensor(TouchSensor touchSensor, byte waitAction) {
        super(waitAction);
        setTouchSensor(touchSensor);
    }

    /**
     * Create the wait touch sensor with the touch sensor port and the waited action.
     *
     * @param waitAction Wait action.
     * @param sensorPort Touch sensor port.
     */
    public WaitTouchSensor(SensorPort sensorPort, byte waitAction) {
        this(new TouchSensor(sensorPort), waitAction);
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    /**
     * Run the wait touch sensor.
     */
    @Override
    public void run() {
        while (this.isFinished()) {
            try {
                this.setFinished(this.getTouchSensor().isPressed());
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {

            }
        }
    }

    // --------------------------------------------------------------------------- Static Components
}
