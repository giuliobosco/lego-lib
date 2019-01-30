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
 * Wait time example class.
 * Questa classe crea un wait time con 2000 millisecondi di attesa, poi stampa
 * ogni 100 millisecondi "Aspetto..." finché non finisce il tempo della wait
 * time. Sfurtta la funzione asincrona del classe.
 */
public class UseWaitTimeAsynchron {
    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitTime in maniera asincrona.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // creo il wait time con 2000 millisecondi di attesa
        WaitTime wt = new WaitTime(2000);

        // avvio l'attesa del tempo impostato prima
        wt.beginWait();

        // aspetto che il tempo sia passato passato mentre
        // stampo "Aspetto..." ogni 100 millisecondi
        while (!wt.isFinished()) {
            // Stampo "Aspetto..."
            System.out.println("Aspetto...");

            // aspetto 100 millisecondi
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {

            }
        }

        // Stampo "finito"
        System.out.println("finito");

        // aspetto che venga cliccato un qualunque tasto del blocco NXT,
        // questo perchè altrimenti il programma terminerebbe subito e non
        // si riuscirebbe a leggere l'ultima cosa stampata.
        Button.waitForAnyPress();
    }
}