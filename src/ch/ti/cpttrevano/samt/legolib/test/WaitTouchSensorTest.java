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
package ch.ti.cpttrevano.samt.legolib.test;

import ch.ti.cpttrevano.samt.legolib.wait.WaitTouchSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.TouchSensor;

/**
 * Test the wait of the touch sensor.
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 1.0
 */
public class WaitTouchSensorTest {
    
    public static void main(String[] args) {
        
        // Set a new touch sensor on port 1
        TouchSensor touch = new TouchSensor(SensorPort.S1);
        
        // Set the wait action to 2 (CLICKED)
        byte action = 2;
        
        // New wait for the touch sensor
        WaitTouchSensor wait = new WaitTouchSensor(touch, action);
        
        wait.start();
    }
}
