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

/**
 * Wait motor example class.
 * Questa classe crea uno wait con l'attesa di 5 roatazioni del motore sulla
 * porta A, poi stampa inizio e poi finito quando il motore ha eseguito 5
 * rotazioni.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class UseWaitMotorSynchron {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitMotor in maniera sincrona.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // Creo lo waiter settato per le 5 rotazioni ed il motore sulla
        // porta A
        WaitMotor wm = new WaitMotor(new SingleMotor('A'), 5);

        // aspetto che il motore esegua 5 rotazioni
        wm.waiter();

        // stampo "finito"
        System.out.println("finito");

        // aspetto che venga cliccato un qualunque tasto del
        // blocco NXT, questo perchè altrimenti il programma
        // terminerebbe subito e non si riuscirebbe a leggere
        // l'ultima cosa stampata.
        Button.waitForAnyPress();
    }
}
