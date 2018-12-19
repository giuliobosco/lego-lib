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
     * Port on the NXT brick of the single motor.
     */
    private char port;

    /**
     * Power of the motor.
     */
    private byte power;

    /**
     * Get the port on the NXT brick of the single motor.
     *
     * @return Port on the NXT brick of the single motor.
     */
    public char getPort() {
        return this.port;
    }

    /**
     * Setter the port on the NXT brick of the single motor.
     *
     * @param port Port on the NXT brick of the single motor.
     */
    public void setPort(char port) {
        this.port = port;
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
        this.power = power;
    }
}
