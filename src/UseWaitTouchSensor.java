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

import lejos.nxt.Button;
import lejos.nxt.SensorPort;

/**
 * Wait time example class.
 * Questa classe crea un wait time con 2000 millisecondi di
 * attesa, stampa "inizio", poi aspetta che lo wait termini
 * e stampa "finito".
 *
 * @author giuliobosco
 * @version 1.0 (01.02.2019)
 */
public class UseWaitTouchSensor {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitTime in maniera sincrona.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // creo il wait time con 2000 millisecondi di attesa
        WaitTouchSensor wtc = new WaitTouchSensor(SensorPort.S1, WaitTouchSensor.CLICKED);

        // stampo inizio
        System.out.println("inizio");

        // aspetto i 2000 millisecondi
        wtc.waitTouchSensor();

        // stampo "finito"
        System.out.println("finito");

        // aspetto che venga cliccato un qualunque tasto del
        // blocco NXT, questo perchè altrimenti il programma
        // terminerebbe subito e non si riuscirebbe a leggere
        // l'ultima cosa stampata.
        Button.waitForAnyPress();
    }
}