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

/**
 * Using Thread.sleep(millis) for wait time.
 * Una alternativa alla classe WaitTime.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-05)
 */
public class UseThreadSleep {

     /**
     * Metodo main della classe, mostra come utilizzare il metodo
     * Thread.sleep(millis), che &egrave; una alternativa alla classe
     * WaitTime.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // per poter utilizzare il metodo Thread.sleep(millis) bisogna
        // utilizzare la struttura try {...} catch (Exception e) {...}
        // questo perch&eacute; la thread potrebbe venir interrotta e 
        // provocherebbe un'eccezione.
        try {
            // stampo il messaggio iniziale, "aspettando..."
            System.out.println("Aspettando...");

            // aspetto i 5000 millisecondi
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        // stampo ilmessaggio finale
        System.out.println("Attesa terminata.");

        // aspetto che venga premuto un bottone sul brick per terminare
        // il programma
        Button.waitForAnyPress();
    }
}