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
 * LineFollower, uses a motor and a light sensor to follow a line.
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 2.0
 */
public class LineFollower extends Navigation {

    // ------------------------------------------------------------------------- Constants

    /**
     * Default value for line on the left (true).
     */
    public static final boolean DEFAULT_LINE_ON_LEFT = true;

    // ------------------------------------------------------------------------- Fields

    /**
     * The wait of the light sensor.
     */
    private WaitLightSensor waitLightSensor;

    /**
     * Line on the left.
     * If true the line follower will keep the line on the left otherwise it
     * will keep the line on the right.
     */
    private boolean lineOnLeft;

    // ------------------------------------------------------------------------- Getters

    /**
     * Set the the line on the left.
     *
     * @param lineOnLeft The line on the left.
     */
    public void setLineOnLeft(boolean lineOnLeft) {
        this.lineOnLeft = lineOnLeft;
    }

    /**
     * Is the line on the left.
     *
     * @return Line on the left.
     */
    public boolean isLineOnLeft() {
        return this.lineOnLeft;
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, creates the line follower with the left motor, the
     * right motor and the light sensor wait.
     *
     * @param leftMotor       The left motor.
     * @param rightMotor      The right motor.
     * @param waitLightSensor The light sensor waiter.
     */
    public LineFollower(SingleMotor leftMotor, SingleMotor rightMotor, WaitLightSensor waitLightSensor) {
        super(leftMotor, rightMotor);
        this.lineOnLeft = DEFAULT_LINE_ON_LEFT;
    }

    // ------------------------------------------------------------------------- Help Methods

    // ------------------------------------------------------------------------- General Methods

    @Override
    public void start() {
        this.waitLightSensor.setComparisonValue((byte) 50);
        this.waitLightSensor.setBigger(this.isLineOnLeft());

        super.start();

        while (true) {
            waitLightSensor.waitLight();

            if (this.isLineOnLeft()) {
                this.right(TURNING);
            } else {
                this.left(TURNING);
            }

            waitLightSensor.setBigger(!waitLightSensor.isBigger());
            waitLightSensor.waitLight();

            if (this.isLineOnLeft()) {
                this.left(TURNING);
            } else {
                this.right(TURNING);
            }
            waitLightSensor.setBigger(!waitLightSensor.isBigger());
        }
    }

}