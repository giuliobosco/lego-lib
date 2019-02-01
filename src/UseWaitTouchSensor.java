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
 * Wait touch sensor example class.
 * Aspetta che il touch sensor sulla porta 1 venga premuto.
 *
 * @author giuliobosco
 * @version 1.1 (01.02.2019)
 */
public class UseWaitTouchSensor {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitTouchSensor.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // creo lo waiter per il touch sensor sulla porta uno, che aspetta
        // unc click del sensore.
        WaitTouchSensor wtc = new WaitTouchSensor(SensorPort.S1,
                WaitTouchSensor.CLICKED);

        // stampo messaggio iniziale
        System.out.println("cliccare il touch sensor sulla porta 1");

        // aspetto che venga cliccato il touch sensor
        wtc.waitTouchSensor();

        // stampo messagigo finale
        System.out.println("touch sensor cliccato");

        // aspetto che venga cliccato un qualunque tasto del
        // blocco NXT, questo perchè altrimenti il programma
        // terminerebbe subito e non si riuscirebbe a leggere
        // l'ultima cosa stampata.
        Button.waitForAnyPress();
    }
}