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
import lejos.nxt.SoundSensor;

/**
 * WaitAnalogSensor, used to wait a value on a sound sensor (microphone).
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 3.1 (2019-02-01)
 */
public class WaitSoundSensor extends WaitAnalogSensor {

    // ------------------------------------------------------------------------- Constants

    // ------------------------------------------------------------------------- Fields

    /**
     * The sound sensor.
     */
    private SoundSensor soundSensor;

    // ------------------------------------------------------------------------- Getters

    /**
     * Get the sound sensor.
     *
     * @return The sound sensor.
     */
    public SoundSensor getSoundSensor() {
        return this.soundSensor;
    }

    // ------------------------------------------------------------------------- Setters

    /**
     * Set the sound sensor.
     *
     * @param soundSensor The sound sensor.
     */
    public void setSoundSensor(SoundSensor soundSensor) {
        this.soundSensor = soundSensor;
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, defines the sensor, the comparison value and if it
     * must be bigger than the value read by the sensor.
     *
     * @param soundSensor     The sound sensor.
     * @param comparisonValue The comparison value.
     * @param bigger          If is bigger than the comparison value.
     */
    public WaitSoundSensor(SoundSensor soundSensor, byte comparisonValue, boolean bigger) {
        super(bigger, comparisonValue);
        this.setSoundSensor(soundSensor);
    }

    /**
     * Constructor method, defines the sensor port, the comparison value and if
     * it must be bigger than the value read by the sensor.
     *
     * @param sensorPort      The port where the sensor is connected.
     * @param comparisonValue The comparison value.
     * @param bigger          If is bigger than the comparison value.
     */
    public WaitSoundSensor(SensorPort sensorPort, byte comparisonValue, boolean bigger) {
        this(new SoundSensor(sensorPort), comparisonValue, bigger);
    }

    // ------------------------------------------------------------------------- Help Methods

    // ------------------------------------------------------------------------- General Methods

    /**
     * Main method that finishes the wait based on the comparison value.
     */
    public void waitSound() {
        boolean finished = false;
        while (!finished) {
            try {
                if (this.isBigger()) {
                    finished = this.getSoundSensor().readValue() > this.getCheckValue();
                } else {
                    finished = this.getSoundSensor().readValue() < this.getCheckValue();
                }
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }
}