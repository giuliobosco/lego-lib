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

/**
 * WaitTime, used to wait time (milliseconds).
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 2.0
 */
public class WaitTime extends Wait {

    // ------------------------------------------------------------------------- Constants
    
    // ------------------------------------------------------------------------- Fields

    /**
     * The time to wait (in milliseconds).
     */
    private long waitTime;

    /**
     * The starting time.
     */
    private long startTime;

    // ------------------------------------------------------------------------- Getters

    /**
     * Get the time to wait.
     *
     * @return The time to wait.
     */
    public long getWaitTime() {
        return this.waitTime;
    }

    /**
     * Get the start time.
     *
     * @return The start time.
     */
    public long getStartTime() {
        return this.startTime;
    }
    
    // ------------------------------------------------------------------------- Setters
    
    /**
     * Set the time to wait checking that the wait is finished.
     *
     * @param waitTime The time to wait.
     */
    protected void setWaitTime(long waitTime) {
        if (this.isFinished()) {
            this.waitTime = waitTime;
        }
    }

    /**
     * Set the start time after doing checks.
     *
     * @param startTime The start time.
     */
    protected void setStartTime(long startTime) {
        if (this.getStartTime() > System.currentTimeMillis() && this.isFinished()) {
            this.startTime = startTime;
        }
    }

    // ------------------------------------------------------------------------- Constructors

    /**
     * Constructor method, defines the time to wait.
     *
     * @param waitTime The time to wait.
     */
    public WaitTime(long waitTime) {
        setWaitTime(waitTime);
    }

    // ------------------------------------------------------------------------- Help Methods
    
    // ------------------------------------------------------------------------- General Methods

    @Override
    public void startWait() {
        this.setStartTime(System.currentTimeMillis());
    }

    @Override
    public boolean isFinished() {
        if (this.getStartTime() + this.getWaitTime() >= System.currentTimeMillis()) {
            this.setWaitTime(Long.MAX_VALUE - getStartTime());
            return true;
        }
        return false;
    }

}