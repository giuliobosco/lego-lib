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
package ch.ti.cpttrevano.samt.legolib.motor;

import legos.nxt.NXTRegulatedMotor;

/**
 * Class for manage a single motor of the NXT brick.
 * In the Lego Mindstorm Environment is rappresented by the green block "Motor".
 *
 * @author giuliobosco
 * @version 1.0
 */
public class SingleMotor {

    /**
     * Mindstorm NXT motor port A.
     */
    public final static char PORT_A = 'A';

    /**
     * Mindstorm NXT motor port B.
     */
    public final static char PORT_B = 'B';

    /**
     * Mindstorm NXT motor port C.
     */
    public final static char PORT_C = 'C';

    /**
     * Minimum motor power.
     */
    public final static byte MIN_POWER = 0;

    /**
     * Maximum motor power.
     */
    public final static byte MAX_POWER = 100;

    /**
     * Motor port on the NXT brick of the single motor.
     */
    private char motorPort;

    /**
     * Motor connected to the brick.
     */
    private NXTRegulatedMotor motor;

    /**
     * Power of the motor.
     */
    private byte power;

    /**
     * Get the Motor port on the NXT brick of the single motor.
     *
     * @return Motor port on the NXT brick of the single motor.
     */
    public char getMotorPort() {
        return this.motorPort;
    }

    /**
     * Setter the motor port on the NXT brick of the single motor.
     *
     * @param motorPort Motor port on the NXT brick of the single motor.
     */
    private void setMotorPort(char motorPort) {
        if (this.isMotorPort(motorPort)) {
            this.motorPort = motorPort;
            this.setMotor(this.motorPort);
        }
    }

    /**
     * Get the motor connected to the brick.
     *
     * @return Motor connected to the brick.
     */
    public NXTRegulatedMotor getMotor() {
        return this.motor;
    }

    /**
     * Set the motor connected to the brick.
     *
     * @param motor Motor connected to the brick.
     */
    private void setMotor(NXTRegulatedMotor motor) {
        this.motor = motor;
    }

    /**
     * Set the motor connected to the brick.
     *
     * @param motorPort Motor port on the NXT brick of the single motor.
     */
    private void setMotor(char motorPort) {
        this.motorPort = motorPort;

        if (motorPort == PORT_A) {
            this.setMotor(Motor.A);
        } else if (motorPort == PORT_B) {
            this.setMotor(Motor.B);
        } else if (motorPort == PORT_C) {
            this.setMotor(Motor.C);
        }
    }

    /**
     * Get the power of the motor.
     *
     * @return Power of the motor
     */
    public byte getPower() {
        return this.power;
    }

    /**
     * Set the power of the motor.
     *
     * @param power Power of the motor.
     */
    public void setPower(byte power) {
        if (this.isPower(power)) {
            this.power = power;
        }
    }

    /**
     * Check if the motor port passed as parameter exists on the NXT brick.
     *
     * @param motorPort Motor port on the NXT brick to check if exists.
     * @return True if the motor port exists on the NXT brick, otherwise false.
     */
    public boolean isMotorPort(char motorPort) {
        if (motorPort == PORT_A || motorPort == PORT_B || motorPort == PORT_C) {
            return true;
        }

        return false;
    }

    /**
     * Check if the power passed as parameter is in the range for the motor.
     *
     * @param power Power to check if is in the range of the motor.
     * @return True if the power is in the range, otherwise false.
     */
    public boolean isPower(byte power) {
        if (power > MIN_POWER && power < MAX_POWER) {
            return true;
        }

        return false;
    }

    /**
     * Initialize the single motor with the motor port and power.
     *
     * @param motorPort$ Motor port on the NXT brick of the single motor.
     * @param power Power of the motor.
     */
    public SingleMotor(char port, byte power) {
        this.motorPort(port);
        this.setPower(power);
    }

    /**
     * Start the motor.
     */
    public void start() {
        this.motor.forward();
        this.motor.setSpeed(this.speed);
    }

    /**
     * Stop the motor.
     */
    public void stop() {
        this.motor.stop();
    }
}
