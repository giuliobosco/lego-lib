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
 * Wait class, used to generalize all waiting classes.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 2.0
 */
public class Wait extends Thread {
    
    // ------------------------------------------------------------------------- Constants

    /**
     * Constant that defines the time to wait (in milliseconds) before making a 
     * new check to finish the wait.
     */
    protected static final long WAIT_TIME = 100;

    // ------------------------------------------------------------------------- Fields
    
    /**
     * Field that tell if the wait is over.
     */
    private boolean finished;

    // ------------------------------------------------------------------------- Getters
    
    /**
     * Get the finished value.
     * 
     * @return The state of waiting (finished or not finished).
     */
    public boolean isFinished() {
        return this.finished;
    }
    
    // ------------------------------------------------------------------------- Setters
    
    /**
     * Set the finished value.
     *
     * @param finished The state of waiting.
     */
    protected void setFinished(boolean finished) {
        this.finished = finished;
    }

    // ------------------------------------------------------------------------- Constructors
    
    /**
     * Constructor method, creates a new wait where the wait is not over.
     */
    public Wait() {
        this.finished = false;
    }

    // ------------------------------------------------------------------------- Help Methods
    
    // ------------------------------------------------------------------------- General Methods
    
    /**
     * Main synchron wait method, where it waits until it's finished.
     */
    public void waiter() {
        this.beginWait();
        try {
            while (!this.isFinished()) {
                sleep(WAIT_TIME);
            }
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * Begin the asynchron wait.
     */
    public void beginWait() {
        this.setFinished(false);
    }
    
}