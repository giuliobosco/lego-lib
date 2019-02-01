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

import lejos.nxt.LightSensor;

/**
 * Proportional line follower.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class ProportionalLineFollower extends Navigation {
    // ------------------------------------------------------------------------------------ Costants

    /**
     * Default value for follow black.
     * Value: true.
     */
    public static final boolean DEFAULT_FOLLOW_BLACK = true;

    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Frontal light sensor for proportional line follower.
     */
    private LightSensor frontLightSensor;

    /**
     * Back light sensor for proportional line follower.
     */
    private LightSensor backLightSensor;

    /**
     * Follow a black line on white ground if true, other ways follow white line on black ground.
     */
    private boolean followBlack;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Set the frontal light sensor for proportional line follower.
     *
     * @param frontLightSensor Frontal light sensor for proportional line follower.
     */
    public void setFrontLightSensor(LightSensor frontLightSensor) {
        this.frontLightSensor = frontLightSensor;
    }

    /**
     * Get the frontal light sensor for proportional line follower.
     *
     * @return Frontal light sensor for proportional line follower.
     */
    public LightSensor getFrontLightSensor() {
        return this.frontLightSensor;
    }

    /**
     * Set the back light sensor for proportional line follower.
     *
     * @param backLightSensor Back light sensor for proportional line follower.
     */
    public void setBackLightSensor(LightSensor backLightSensor) {
        this.backLightSensor = backLightSensor;
    }

    /**
     * Get the back light sensor for proportional line follower.
     *
     * @return Back light sensor for proportional line follower.
     */
    public LightSensor getBackLightSensor() {
        return this.backLightSensor;
    }

    /**
     * Set the follow black.
     *
     * @param followBlack Follow black.
     */
    public void setFollowBlack(boolean followBlack) {
        this.followBlack = followBlack;
    }

    /**
     * Is follow black.
     *
     * @return Follow black.
     */
    public boolean isOnBlack() {
        return this.followBlack;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the proportional line follower with the left motor, right motor, frontal light sensor
     * and back light sensor.
     *
     * @param leftMotor        Left motor.
     * @param rightMotor       Right motor.
     * @param frontLightSensor Front light sensor.
     * @param backLightSensor  Back light sensor.
     */
    public ProportionalLineFollower(SingleMotor leftMotor,
                                    SingleMotor rightMotor,
                                    LightSensor frontLightSensor,
                                    LightSensor backLightSensor) {
        super(leftMotor, rightMotor);

        this.setFrontLightSensor(frontLightSensor);
        this.setBackLightSensor(backLightSensor);
        this.setFollowBlack(DEFAULT_FOLLOW_BLACK);
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    /**
     * Run the proportional line follower.
     */
    @Override
    public void start() {
        super.start();
        while (true) {
            if (this.frontLightSensor.getLightValue() < 50) {
                byte value = (byte) this.frontLightSensor.getLightValue();
                value -= this.getPower();
                value /= 1.5;

                this.setTurning(value);
            } else {
                if (this.backLightSensor.getLightValue() < 50) {
                    byte value = (byte) this.frontLightSensor.getLightValue();
                    value -= this.getPower();
                    value /= 1.5;

                    this.setTurning(value);
                } else {
                    this.setTurning((byte) 0);
                }
            }
        }
    }


    // --------------------------------------------------------------------------- Static Components

}
