/*
 * The MIT License
 *
 * Copyright 2018 SAMT.
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

package ch.ti.cpttrevano.samt.legolib.linefollower;

import ch.ti.cpttrevano.samt.legolib.motor.Navigation;
import ch.ti.cpttrevano.samt.legolib.motor.SingleMotor;
import ch.ti.cpttrevano.samt.legolib.wait.WaitLightSensor;

/**
 * @author giuliobosco
 * @version 1.0
 */
public class LineFollower extends Navigation {
    // ------------------------------------------------------------------------------------ Costants

    /**
     * Default vaue for light on the left.
     * Value: true.
     */
    public static final boolean DEFAULT_LIGHT_ON_LEFT = true;

    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Wait light sensor.
     */
    private WaitLightSensor waitLightSensor;

    /**
     * Line on the left.
     * If true the line follower will keep the line on the left other ways it will
     * keep the line on the right.
     */
    private boolean lineOnLeft;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the the line on the left.
     *
     * @param lineOnLeft Line on the left.
     */
    public void setLineOnLeft(boolean lineOnLeft) {
        if (!this.isAlive()) {
            this.lineOnLeft = lineOnLeft;
        }
    }

    /**
     * Is the line on the left.
     *
     * @return Line on the left.
     */
    public boolean isLineOnLeft() {
        return this.lineOnLeft;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the line follower with the left motor, the right motor and the wait light sensor.
     *
     * @param leftMotor       Left motor.
     * @param rightMotor      Right motor.
     * @param waitLightSensor Light sensor waiter.
     */
    public LineFollower(SingleMotor leftMotor, SingleMotor rightMotor, WaitLightSensor waitLightSensor) {
        super(leftMotor, rightMotor);

        this.lineOnLeft = DEFAULT_LIGHT_ON_LEFT;
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    /**
     * Execute the line follower.
     */
    @Override
    public void run() {
        waitLightSensor.setValue((byte) 50);
        waitLightSensor.setBigger(this.isLineOnLeft());
        while (!isAlive()) {
            waitLightSensor.waiter();

            if (this.isLineOnLeft()) {
                this.right(TURNING);
            } else {
                this.left(TURNING);
            }

            waitLightSensor.setBigger(!waitLightSensor.isBigger());
            waitLightSensor.waiter();

            if (this.isLineOnLeft()) {
                this.left(TURNING);
            } else {
                this.right(TURNING);
            }
            waitLightSensor.setBigger(!waitLightSensor.isBigger());
        }
    }


    // --------------------------------------------------------------------------- Static Components

}
