/*
 * The MIT License
 *
 * Copyright 2019 giuliobosco.
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

import lejos.nxt.Button;
import lejos.nxt.SensorPort;

/**
 * Wait ultrasonic sensor example class.
 * Aspetta che il sensore ad ultrasuoni (distanza) sulla porta 1
 * legga un valore maggiore di 50cm, poi aspetta che venga premuto
 * un qualunque tasto sul brick, poi aspetta di leggere un valore
 * minore di 50cm sul sensore.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-01)
 */
public class UseWaitUltrasonicSensor {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitUltrasonicSensor.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // creo lo waiter per il ultrasonic sensor sulla porta uno.
        WaitUltrasonicSensor wus = new WaitUltrasonicSensor(
                SensorPort.S1, (byte) 50, true);

        // stampo messaggio iniziale, aspetto che il sensore ad ultrasuoni
        // legga un valore maggiore di 50cm
        System.out.println(
                "mettere il sensore piu lontano di 50cm dal sensore");
        wus.waitUltrasonic();

        // aspetto che venga premuto un qualunque bottone sul brick
        Button.waitForAnyPress();

        // stampo messaggio intermedio, aspetto che il sensore ad
        // ultrasuoni legga un valore miniore di 50cm
        wus.setBigger(false);
        System.out.println(
                "mettere il sensore piu vicino di 50cm dal sensore");
        wus.waitUltrasonic();

        // stampo messaggio finale
        System.out.println("fine del test");

        // aspetto che venga premuto un bottone sul brick per terminare
        // il programma
        Button.waitForAnyPress();
    }
}
