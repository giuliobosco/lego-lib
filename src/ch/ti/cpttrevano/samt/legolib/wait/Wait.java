
package ch.ti.cpttrevano.samt.legolib;

/**
 * Wait, used for generalization of all waiting class.
 * In the Lego Mindstorm Environment is rappresented by the orange block "Wait".
 *
 * @author giuliobosco
 * @version 1.0
 */
public class Wait extends Thread {

    /**
     * Empty constructor.
     */
    Wait() {}

    /**
     * Empty wait method.
     */
    public void wait() {}

    /**
     * Empty begin wait method.
     */
    public void beginWait() {}

    /**
     * Is finished method, returns always true.
     */
    public boolean isFinished() {
        return true;
    }
}
