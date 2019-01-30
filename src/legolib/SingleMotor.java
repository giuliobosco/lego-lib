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

import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.Motor;

/**
 * Management of a motor in a NXT brick.
 * In the LEGO Mindstorms environment is represented by the green block "Motor".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 2.0
 */
public class SingleMotor {

    // ------------------------------------------------------------------------- Constants
    
    
    /**
     * NXT brick motor port A.
     */
    public final static char PORT_A = 'A';

    /**
     * NXT brick motor port B.
     */
    public final static char PORT_B = 'B';

    /**
     * NXT brick motor port C.
     */
    public final static char PORT_C = 'C';

    /**
     * Defines the minimum motor power.
     */
    public final static byte MIN_POWER = 0;

    /**
     * Defines the maximum motor power.
     */
    public final static byte MAX_POWER = 100;

    // ------------------------------------------------------------------------- Fields

    /**
     * The port on the NXT brick of the single motor.
     */
    private char motorPort;

    /**
     * The motor connected to the brick.
     */
    private NXTRegulatedMotor motor;

    /**
     * The power of the motor.
     */
    private byte power;

    // ------------------------------------------------------------------------- Getters

    /**
     * Get the motor port on the NXT brick of the single motor.
     *
     * @return The port where the motor is connected.
     */
    public char getMotorPort() {
        return this.motorPort;
    }
    
    /**
     * Get the motor connected to the brick.
     *
     * @return The motor connected to the brick.
     */
    public NXTRegulatedMotor getMotor() {
        return this.motor;
    }

    /**
     * Get the power of the motor.
     *
     * @return The power of the motor.
     */
    public byte getPower() {
        return this.power;
    }
    
    // ------------------------------------------------------------------------- Setters

    /**
     * Set the motor port on the NXT brick of the single motor.
     *
     * @param motorPort The port where the motor is connected.
     */
    private void setMotorPort(char motorPort) {
        if (this.isMotorPort(motorPort)) {
            this.motorPort = motorPort;
            this.setMotor(this.motorPort);
        }
    }

    /**
     * Set the motor connected to the brick.
     *
     * @param motor The motor connected to the brick.
     */
    private void setMotor(NXTRegulatedMotor motor) {
        this.motor = motor;
    }

    /**
     * Set the motor connected to the brick.
     *
     * @param motorPort The port where the motor is connected.
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
     * Set the power of the motor.
     *
     * @param power The power of the motor.
     */
    public void setPower(byte power) {
        if (power > MAX_POWER) {
            power = MAX_POWER;
        } else if (power < MIN_POWER) {
            power = MIN_POWER;
        }
        this.power = power;
        this.getMotor().setSpeed(this.getPower());
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, creates the single motor with the motor port.
     *
     * @param port The single motor port.
     */
    public SingleMotor(char port) {
        this.setMotorPort(port);
    }

    // ------------------------------------------------------------------------- Help Methods

    /**
     * Check if the motor port passed as parameter exists on the NXT brick.
     *
     * @param motorPort The motor port on the NXT brick to check if exists.
     * @return True if the motor port exists on the NXT brick, otherwise false.
     */
    public boolean isMotorPort(char motorPort) {
        if (motorPort == PORT_A || motorPort == PORT_B || motorPort == PORT_C) {
            return true;
        }
        return false;
    }

    /**
     * Increases the power of the motor.
     *
     * @param value The value to increase the power.
     */
    public void increasePower(byte value) {
        this.setPower((byte) (this.getPower() + value));
    }

    /**
     * Decreases the power of the motor.
     *
     * @param value The value to decrease the power.
     */
    public void decreasePower(byte value) {
        this.setPower((byte) (this.getPower() - value));
    }

    // ------------------------------------------------------------------------- General Methods

    /**
     * Starts the motor.
     */
    public void start() {
        this.getMotor().forward();
        this.getMotor().setSpeed(this.getPower());
    }

    /**
     * Stops the motor.
     */
    public void stop() {
        this.getMotor().stop();
    }

    /**
     * Rotate the motor by an angle.
     *
     * @param angle The angle of the rotation.
     */
    public void rotate(int angle) {
        this.getMotor().rotate(angle);
    }

}