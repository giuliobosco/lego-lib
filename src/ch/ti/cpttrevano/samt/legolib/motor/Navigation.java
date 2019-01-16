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

package ch.ti.cpttrevano.samt.legolib.motor;

import lejos.nxt.Motor;

/**
 * @author giuliobosco
 * @version 1.0
 */
public class Navigation extends Thread {
    // ------------------------------------------------------------------------------------ Costants

    /**
     * Turning of the navigation.
     */
    public static final byte TURNING = 10;

    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Power of the navigation.
     */
    private byte power;

    /**
     * Turning of the navigation.
     */
    private byte turning;

    /**
     * Navigation left motor.
     */
    SingleMotor leftMotor;

    /**
     * Navigation right motor.
     */
    SingleMotor rightMotor;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the power of the navigation.
     *
     * @param power Power of the navigation.
     */
    public void setPower(byte power) {
        this.power = power;
    }

    /**
     * Get the power of the navigation.
     *
     * @return Power of the navigation.
     */
    public byte getPower() {
        return this.power;
    }

    /**
     * Set the turning of the navigation.
     *
     * @param turning Turning of the navigation.
     */
    public void setTurning(byte turning) {
        this.turning = turning;
    }

    /**
     * Get the turning of the navigation.
     *
     * @return Turning of the navigation.
     */
    public byte getTurning() {
        return this.turning;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the navigation with the left and right motor.
     *
     * @param leftMotor  Navigation left motor.
     * @param rightMotor Navigation right motor.
     */
    public Navigation(SingleMotor leftMotor, SingleMotor rightMotor) {
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods
    // --------------------------------------------------------------------------- Static Components

}
