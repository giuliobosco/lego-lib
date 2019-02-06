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
 * Navigation with two motors connected in a NXT brick.
 * In the LEGO Mindstorms environment is represented by the green block "Move".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 3.3 (2019-02-06)
 */
public class Navigation {
    
    // ------------------------------------------------------------------------- Constants

    /**
     * The default turning of the navigation.
     */
    public static final byte TURNING = 50;

    /**
     * The minimum navigation turning.
     */
    public static final byte MIN_TURNING = SingleMotor.MIN_POWER;

    /**
     * The maximum navigation turning.
     */
    public static final byte MAX_TURNING = SingleMotor.MAX_POWER;

    // ------------------------------------------------------------------------- Fields

    /**
     * The power of the navigation.
     */
    private byte power;

    /**
     * The turning of the navigation.
     */
    private byte turning;

    /**
     * The left motor of the navigation.
     */
    private SingleMotor leftMotor;

    /**
     * The right motor of the navigation.
     */
    private SingleMotor rightMotor;

    // ------------------------------------------------------------------------- Getters

    /**
     * Get the power of the navigation.
     *
     * @return Power of the navigation.
     */
    public byte getPower() {
        return this.power;
    }
    
    /**
     * Get the turning of the navigation.
     *
     * @return The turning of the navigation.
     */
    public byte getTurning() {
        return this.turning;
    }
    
    // ------------------------------------------------------------------------- Setters
    
    /**
     * Set the power of the navigation.
     *
     * @param power The power of the navigation.
     */
    public void setPower(byte power) {
        if (power > SingleMotor.MAX_POWER) {
            power = SingleMotor.MAX_POWER;
        } else if (power < SingleMotor.MIN_POWER) {
            power = SingleMotor.MIN_POWER;
        }
        this.power = power;
        this.updatePowerMotors();
    }

    /**
     * Set the turning of the navigation.
     *
     * @param turning The turning of the navigation.
     */
    public void setTurning(byte turning) {
        if (turning > MAX_TURNING) {
            turning = MAX_TURNING;
        } else if (turning < MIN_TURNING) {
            turning = MIN_TURNING;
        }
        this.turning = turning;
        this.updateTurningMotors();
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, creates the navigation with the left and right motor.
     *
     * @param leftMotor  The left motor.
     * @param rightMotor The right motor.
     */
    public Navigation(SingleMotor leftMotor, SingleMotor rightMotor) {
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }

    /**
     * Constructor method, creates the navigation with the motor ports.
     *
     * @param leftMotor  The port of the left motor.
     * @param rightMotor The port of the right motor.
     */
    public Navigation(char leftMotor, char rightMotor) {
        this(new SingleMotor(leftMotor), new SingleMotor(rightMotor));
    }

    // ------------------------------------------------------------------------- Help Methods

    /**
     * Updates the power and consequently the turning of the motors.
     */
    private void updatePowerMotors() {
        this.leftMotor.setPower(this.getPower());
        this.rightMotor.setPower(this.getPower());
        this.updateTurningMotors();
    }

    /**
     * Updates the turning of the motors.
     */
    private void updateTurningMotors() {
        if (this.getTurning() > 0) {
            this.leftMotor.decreasePower(this.getTurning());
            this.rightMotor.increasePower(this.getTurning());
        } else {
            this.leftMotor.increasePower((byte) - this.getTurning());
            this.rightMotor.decreasePower((byte) - this.getTurning());
        }
    }

    // ------------------------------------------------------------------------- General Methods

    /**
     * Increases the power of the navigation.
     *
     * @param value The increase power value.
     */
    public void increasePower(byte value) {
        this.setPower((byte) (this.getPower() + value));
    }

    /**
     * Decreases the power of the navigation.
     *
     * @param value The decrease power value.
     */
    public void decreasePower(byte value) {
        this.setPower((byte) (this.getPower() - value));
    }

    /**
     * Increases the turning of the navigation.
     *
     * @param value The increase turning value.
     */
    public void increaseTurning(byte value) {
        this.setTurning((byte) (this.getTurning() + value));
    }

    /**
     * Decreases the turning of the navigation.
     *
     * @param value The increase turning value.
     */
    public void decreaseTurning(byte value) {
        this.setTurning((byte) (this.getTurning() - value));
    }

    /**
     * Turn the navigation to left.
     *
     * @param turning The value to turn to left.
     */
    public void left(byte turning) {
        this.decreaseTurning(turning);
    }

    /**
     * Turn the navigation to right.
     *
     * @param turning The value to turn to right.
     */
    public void right(byte turning) {
        this.increaseTurning(turning);
    }
    
    /**
     * Start the navigation.
     */
    public void start() {
        this.setPower(SingleMotor.MAX_POWER);
        this.leftMotor.start();
        this.rightMotor.start();
    }

    /**
     * Stop the navigation.
     */
    public void stop() {
        this.leftMotor.stop();
        this.rightMotor.stop();
    }

}