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

import lejos.nxt.Button;
import lejos.nxt.SensorPort;

/**
 * Example of using the WaitLightSensor class.
 * Useful for testing all the methods.
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 2.0 (2019-02-06)
 */
public class UseWaitLightSensor {

    /**
     * Main method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        // New wait for the light sensor.
        WaitLightSensor wait = new WaitLightSensor(SensorPort.S1, (byte) 50, true);
        // Wait for a clear light.
        System.out.println("Put on a clear light.");
        wait.waitLight();
        System.out.println("OK, press a button.");
        // Wait for the press of a button.
        Button.waitForAnyPress();
        // Wait for a dark light.
        wait.setBigger(false);
        System.out.println("Put on a dark light.");
        wait.waitLight();
        System.out.println("OK.");
        
    }
    
}