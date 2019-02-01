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
 * Wait nxt button example class.
 * Testa la funzionalita dell'aspettare la premuta dei bottoni sul brick
 * nxt. Prima richiede di premere il tasto sinistro, poi quello di enter,
 * ed infine il tasto destro.
 *
 * @author giuliobosco
 * @version 1.1 (2019-02-01)
 */
public class UseWaitNxtButton {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitNxtButton.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // aspetto che il tasto sinistro venga premuto
        System.out.println("Press left button to continue");
        WaitNxtButton.leftButton();

        // aspetto che il tasto enter venga premuto
        System.out.println(
                "Button pressed\n\nPress enter button to continue");
        WaitNxtButton.enterButton();

        // aspetto che il tasto destro venga premuto
        System.out.println(
                "Button pressed\n\nPress right button to continue");
        WaitNxtButton.rightButton();
        System.out.println("Button pressed\n\n");

        // aspetto che venga cliccato un qualunque tasto del
        // blocco NXT, questo perchè altrimenti il programma
        // terminerebbe subito e non si riuscirebbe a leggere
        // l'ultima cosa stampata.
        Button.waitForAnyPress();
    }
}
