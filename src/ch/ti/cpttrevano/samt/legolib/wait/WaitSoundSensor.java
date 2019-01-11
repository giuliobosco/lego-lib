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
import lejos.nxt.SoundSensor;

/**
 * Wait the sound sensor.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class WaitSoundSensor extends WaitAnalogSensor {
    // ------------------------------------------------------------------------------------ Costants
    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Sound sensor.
     */
    private SoundSensor soundSensor;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the sound sensor.
     *
     * @param soundSensor Sound sensor.
     */
    public void setSoundSensor(SoundSensor soundSensor) {
        if (this.isFinished()) {
            this.soundSensor = soundSensor;
        }
    }

    /**
     * Get the sound sensor.
     *
     * @return Sound sensor.
     */
    public SoundSensor getSoundSensor() {
        return this.soundSensor;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the waiter with the bigger value than the comparison value, the comparison value and
     * the sound sensor.
     *
     * @param bigger      Bigger than the comparison value.
     * @param value       Comparison value.
     * @param soundSensor Sound sensor.
     */
    public WaitSoundSensor(boolean bigger, byte value, SoundSensor soundSensor) {
        super(bigger, value);

        this.setSoundSensor(soundSensor);
    }

    /**
     * Create the waiter with the bigger than comparison value, the comparison value and the sound
     * sensor port.
     *
     * @param bigger     Bigger than comparison value.
     * @param value      Comparison value.
     * @param sensorPort Sound sensor port.
     */
    public WaitSoundSensor(boolean bigger, byte value, SensorPort sensorPort) {
        this(bigger, value, new SoundSensor(sensorPort));
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    /**
     * Run the wait sound sensor.
     */
    @Override
    public void run() {
        this.setFinished(false);

        while (this.isFinished()) {
            try {
                if (this.isBigger()) {
                    this.setFinished(this.soundSensor.readValue() > this.getValue());
                } else {
                    this.setFinished(this.soundSensor.readValue() < this.getValue());
                }

                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {

            }
        }
    }

    // --------------------------------------------------------------------------- Static Components

}
