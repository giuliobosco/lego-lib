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
import lejos.nxt.SoundSensor;

/**
 * WaitAnalogSensor, used to wait a sound sensor (microphone).
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 2.0
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
     * @param soundSensor The suond sensor.
     */
    public void setSoundSensor(SoundSensor soundSensor) {
        if (this.isFinished()) {
            this.soundSensor = soundSensor;
        }
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, defines the sensor, the comparison value and if it 
     * must be bigger than the value read by the sensor.
     *
     * @param bigger If is bigger than the comparison value.
     * @param checkValue The comparison value.
     * @param soundSensor The sound sensor.
     */
    public WaitSoundSensor(boolean bigger, byte checkValue, SoundSensor soundSensor) {
        super(bigger, checkValue);
        this.setSoundSensor(soundSensor);
    }

    /**
     * Constructor method, defines the sensor port, the comparison value and if 
     * it must be bigger than the value read by the sensor.
     *
     * @param bigger If is bigger than the comparison value.
     * @param checkValue The comparison value.
     * @param sensorPort The port where the sensor is connected.
     */
    public WaitSoundSensor(boolean bigger, byte checkValue, SensorPort sensorPort) {
        this(bigger, checkValue, new SoundSensor(sensorPort));
    }

    // ------------------------------------------------------------------------- Help Methods
    
    // ------------------------------------------------------------------------- General Methods

    @Override
    public void run() {
        while (this.isFinished()) {
            try {
                if (this.isBigger()) {
                    this.setFinished(this.getSoundSensor().readValue() > this.getCheckValue());
                } else {
                    this.setFinished(this.getSoundSensor().readValue() < this.getCheckValue());
                }
                sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }

}