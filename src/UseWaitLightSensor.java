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
 * Wait light sensor example class.
 * Aspetta che il sensore di intensita di luce riflessa collegato
 * alla porta 1 vegna messo su una superfice chiara, e poi scura.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-01)
 */
public class UseWaitLightSensor {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitLightSensor.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // creo lo waiter per il light sensor, sulla porta uno
        WaitLightSensor wls = new WaitLightSensor(
                SensorPort.S1, (byte)50, true);

        // stampo il messaggio iniziale e aspetto che il sensore
        // legga un valore alto piu alto di 50.
        System.out.println("Mettere su superficie chiara");
        wls.waitLight();

        Button.waitForAnyPress();

        // stampo il messaggio intermedio e aspetto che il sensore
        // legga un valore piu basso di 50.
        wls.setBigger(false);
        System.out.println("Mettere su superfice scura");
        wls.waitLight();

        // stampo messaggio finale
        System.out.println("Fine del test");

        // aspetto che venga premuto un bottone sul brick per terminare
        // il programma
        Button.waitForAnyPress();
    }
}
