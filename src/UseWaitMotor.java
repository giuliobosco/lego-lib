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

/**
 * Wait motor example class.
 * Aspetta che il motore effettui 3 rotazioni.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-01)
 */
public class UseWaitMotor {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitMotor.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // creo il gestore del motore
        SingleMotor m = new SingleMotor('A');
        // creo lo waiter del motore
        WaitMotor wm = new WaitMotor(m, 3);

        // stampo il messaggio iniziale
        System.out.println("Avvio motore");
        // setto la velocita del motore a 10
        m.setPower((byte)10);
        // avvio il motore
        m.start();

        // aspetto le 3 rotazioni
        wm.waitMotor();

        // stampo il messaggio finale
        System.out.println("Fermo motore");
        // fermo il motore
        m.stop();

        // aspetto che venga premuto un bottone sul brick per terminare
        // il programma
        Button.waitForAnyPress();
    }
}
