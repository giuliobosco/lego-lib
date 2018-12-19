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
package ch.ti.cpttrevano.samt.legolib.wait;

/**
 * WaitTime, wait milliseconds.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class WaitTime extends Wait {

    /**
     * Time to wait.
     */
    private long time;

    /**
     * Start time.
     */
    private long startTime;

    /**
     * Get the time to wait.
     *
     * @return Time to wait.
     */
    public long getTime() {
        return this.time;
    }

    /**
     * Set the time to wait, it will be setted only if isFinished returns true.
     *
     * @param time Time to wait.
     */
    public long setTime(long time) {
        if (this.isFinished()) {
            this.time = time;
        }
    }

    /**
     * Get the start time.
     *
     * @return Start time.
     */
    public long getStartTime() {
        return this.startTime;
    }

    /**
     * Initialize the WaitTime with the time to wait.
     */
    public WaitTime(long time) {
        this.setTime(time);
    }

    /**
     * Begin the time to wait.
     */
    public void beginWait() {
        this.startTime = System.currentTimeMillis();
    }

    /**
     * Check if the time to wait is finished, use asynchron.
     *
     * @return True if is finished.
     */
    public boolean isFinished() {
        if (startTime + time >= System.currentTimeMillis()) {
            this.time = Long.MAX_VALUE - this.startTime;
            return true;
        }

        return false;
    }

    /**
     * Wait the time, use synchron.
     */
    public void wait() {
        this.beginWait();
        while (!this.isFinished()) {

        }
    }
}
