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
 * Test the wait of the ultrasonic sensor.
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 1.0
 */
public class WaitUltrasonicSensorTest {

    public static void main(String[] args) {

        // Set a new ultrasonic sensor on port 1
        UltrasonicSensor ultrasonic = new UltrasonicSensor(SensorPort.S1);

        // Set the value to read to 50
        byte value = 50;

        // The value must be bigger
        boolean bigger = true;

        // New wait for the ultrasonic sensor
        WaitUltrasonicSensor wait = new WaitUltrasonicSensor(bigger, value, ultrasonic);

        // Start the wait
        wait.start();
    }
}
