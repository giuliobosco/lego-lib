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

import lejos.nxt.LightSensor;

/**
 * ProportionalLineFollower, uses the navigation and two light sensors to follow 
 * a line proportionally.
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 3.0 (2019-02-03)
 */
public class ProportionalLineFollower extends Navigation {
    
    // ------------------------------------------------------------------------- Constants

    /**
     * Default value for follow a black line (true).
     */
    public static final boolean DEFAULT_FOLLOW_BLACK = true;

    // ------------------------------------------------------------------------- Fields

    /**
     * The frontal light sensor for proportional line follower.
     */
    private LightSensor frontLightSensor;

    /**
     * The back light sensor for proportional line follower.
     */
    private LightSensor backLightSensor;

    /**
     * Follow a black line on white ground if true. 
     * Otherwise follow white line on black ground.
     */
    private boolean followBlack;

    // ------------------------------------------------------------------------- Getters

    /**
     * Get the frontal light sensor for proportional line follower.
     *
     * @return The frontal light sensor.
     */
    public LightSensor getFrontLightSensor() {
        return this.frontLightSensor;
    }
    
    /**
     * Get the back light sensor for proportional line follower.
     *
     * @return The back light sensor.
     */
    public LightSensor getBackLightSensor() {
        return this.backLightSensor;
    }
    
    /**
     * Tells if it's following a black line.
     *
     * @return If following a black line.
     */
    public boolean isOnBlack() {
        return this.followBlack;
    }

    // ------------------------------------------------------------------------- Setters

    /**
     * Set the frontal light sensor for proportional line follower.
     *
     * @param frontLightSensor The frontal light sensor.
     */
    public void setFrontLightSensor(LightSensor frontLightSensor) {
        this.frontLightSensor = frontLightSensor;
    }
    
    /**
     * Set the back light sensor for proportional line follower.
     *
     * @param backLightSensor The back light sensor.
     */
    public void setBackLightSensor(LightSensor backLightSensor) {
        this.backLightSensor = backLightSensor;
    }

    /**
     * Set the follow of a black line.
     *
     * @param followBlack Follow a black line.
     */
    public void setFollowBlack(boolean followBlack) {
        this.followBlack = followBlack;
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, creates the proportional line follower with the left 
     * motor, the right motor, the front light sensor and the back light sensor.
     *
     * @param leftMotor        The left motor.
     * @param rightMotor       The right motor.
     * @param frontLightSensor The front light sensor.
     * @param backLightSensor  The back light sensor.
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

    // ------------------------------------------------------------------------- Help Methods
    
    // ------------------------------------------------------------------------- General Methods

    @Override
    public void start() {
        // Start of the navigation.
        super.start();
        while (true) {
            if (this.getFrontLightSensor().getLightValue() < 50) {
                byte value = (byte) this.getFrontLightSensor().getLightValue();
                value -= this.getPower();
                value /= 1.5;
                this.setTurning(value);
            } else {
                if (this.getBackLightSensor().getLightValue() < 50) {
                    byte value = (byte) this.getBackLightSensor().getLightValue();
                    value -= this.getPower();
                    value /= 1.5;
                    this.setTurning(value);
                } else {
                    this.setTurning((byte) 0);
                }
            }
        }
    }

}