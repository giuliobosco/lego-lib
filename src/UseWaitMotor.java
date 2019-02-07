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

/**
 * Example of using the WaitMotor class. 
 * Waits for three rotations.
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 1.1 (2019-02-07)
 */
public class UseWaitMotor {

    /**
     * Main method
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        // Set the motor on port 'A'.
        SingleMotor m = new SingleMotor('A');
        // New wait for the motor.
        WaitMotor wait = new WaitMotor(m, 3);
        // Start the motor.
        System.out.println("Start motor.");
        m.setPower((byte) 10);
        m.start();
        // Wait for three rotations.
        wait.waitMotor();
        // Stop the motor.
        System.out.println("Stop motor.");
        m.stop();

    }
}