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

/**
 * Navigation with NXT brick.
 * In the Lego Mindstorm Environment is rappresented by the green block "Move".
 *
 * @author giuliobosco
 * @version 1.5
 */
public class Navigation extends Thread {
    // ------------------------------------------------------------------------------------ Costants

    /**
     * Turning of the navigation.
     */
    public static final byte TURNING = 10;

    /**
     * Minimum navigation turning.
     */
    public static final byte MIN_TURNING = SingleMotor.MIN_POWER;

    /**
     * Maximum navigation turning.
     */
    public static final byte MAX_TURNING = SingleMotor.MAX_POWER;

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
    private SingleMotor leftMotor;

    /**
     * Navigation right motor.
     */
    private SingleMotor rightMotor;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the power of the navigation.
     *
     * @param power Power of the navigation.
     */
    public void setPower(byte power) {
        if (power > SingleMotor.MAX_POWER) {
            this.power = SingleMotor.MAX_POWER;
        } else if (power < SingleMotor.MIN_POWER) {
            this.power = SingleMotor.MIN_POWER;
        } else {
            this.power = power;
        }

        this.updatePowerMotors();
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
        if (turning > MAX_TURNING) {
            this.turning = MAX_TURNING;
        } else if (turning < MIN_TURNING) {
            this.turning = MIN_TURNING;
        } else {
            this.turning = turning;
        }

        this.updateTurningMotors();
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

    /**
     * Create the navigation with the left and right motors ports.
     *
     * @param leftMotor  Navigation left motor port.
     * @param rightMotor Navigation right motor port.
     */
    public Navigation(char leftMotor, char rightMotor) {
        this(new SingleMotor(leftMotor), new SingleMotor(rightMotor));
    }

    // -------------------------------------------------------------------------------- Help Methods

    /**
     * Update the power to the navigation motors and also update the motors.
     */
    private void updatePowerMotors() {
        this.leftMotor.setPower(this.getPower());
        this.rightMotor.setPower(this.getPower());

        this.updateTurningMotors();
    }

    /**
     * Update the turning to the navigation motors.
     */
    private void updateTurningMotors() {
        if (this.getTurning() > 0) {
            this.leftMotor.decreasePower(this.getTurning());
            this.rightMotor.increasePower(this.getTurning());
        } else {
            this.leftMotor.increasePower((byte) -this.getTurning());
            this.rightMotor.decreasePower((byte) -this.getTurning());
        }
    }

    /**
     * Increase the power of the navigation.
     *
     * @param value Value to increase the power of the navigation.
     */
    public void increasePower(byte value) {
        this.setPower((byte) (this.getPower() + value));
    }

    /**
     * Decrease the power of the navigation.
     *
     * @param value Value to decrease the power of the navigation.
     */
    public void decreasePower(byte value) {
        this.setPower((byte) (this.getPower() - value));
    }

    /**
     * Increase the turning of the navigation.
     *
     * @param value Value to increase the turning of the navigation.
     */
    public void increaseTurning(byte value) {
        this.setTurning((byte) (this.getTurning() + value));
    }

    /**
     * Decrease the turning of the navigation.
     *
     * @param value Value to decrease the turning of the navigation.
     */
    public void decreaseTurning(byte value) {
        this.setTurning((byte) (this.getTurning() - value));
    }

    /**
     * Turn the navigation left.
     *
     * @param turning Value to turn left.
     */
    public void left(byte turning) {
        this.decreasePower(turning);
    }

    /**
     * Turn the navigation right.
     *
     * @param turning Value to turn right.
     */
    public void right(byte turning) {
        this.increasePower(turning);
    }

    // ----------------------------------------------------------------------------- General Methods

    /**
     * Start the navigation.
     */
    public void startNavigation() {
        this.leftMotor.start();
        this.rightMotor.start();

        this.setPower((byte) 0);
    }

    /**
     * Stop the navigation.
     */
    public void stopNavigation() {
        this.leftMotor.start();
        this.rightMotor.start();
    }

    // --------------------------------------------------------------------------- Static Components

}
