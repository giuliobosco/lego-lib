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

import lejos.nxt.Button;
import lejos.nxt.SensorPort;

/**
 * Wait light sensor example class.
 * Questa classe crea un wait che attende che il sensore di luce sulla porta
 * S1, legga un valore maggiore di 50%. Stampa inizio, poi mentre aspetta che
 * il sensore legga il valore deciso stampa ogni 100 millisecondi "Aspetto..."
 * Dopo di che stampa "finito". Sfurtta la funzione asincrona della classe.
 *
 * @author giuliobosco
 * @version 1.0 (30.01.2019)
 */
public class UseWaitTouchAsynchron {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitLightSensor in maniera asincrona.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // Creo lo waiter settando la ricerca del valore magggiore di 50
        // sulla porta S1
        WaitTouchSensor wts = new WaitTouchSensor(
                WaitDigitalSensor.CLICKED, SensorPort.S1);

        // aspetto che il sensore legga il valore maggiore di 50
        while (!wts.isFinished()) {
            // stampo "Aspetto..."
            System.out.println("Aspetto...");

            // aspetto 100 millisecondi
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {

            }
        }

        // Stampa "finito"
        System.out.println("finito");

        // aspetto che venga cliccato un qualunque tasto del blocco NXT,
        // questo perchè altrimenti il programma terminerebbe subito e non
        // si riuscirebbe a leggere l'ultima cosa stampata.
        Button.waitForAnyPress();
    }
}