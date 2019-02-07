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
 * Testa il funzionamento del touch sensor.
 * Stampa i valori che legge dal touch sensor sulla porta 1.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-07)
 */
public class TestTouchSensor {

    /**
     * Main method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 5; i++) {
                // ogni 5 cicli stampa la linea in alto per differenziare i bottoni
                if (i == 0) {
                    System.out.println("L   R   E   B");
                }
                // se un bottone è premuto scrivi nella sua variabile down altrimenti up
                String left = Button.LEFT.isDown() == true ? "down" : "up  ";
                String right = Button.RIGHT.isDown() == true ? "down" : "up  ";
                String enter = Button.ENTER.isDown() == true ? "down" : "up  ";
                String back = Button.ESCAPE.isDown() == true ? "down" : "up  ";
                // concatena le variabili di ogni bottone
                System.out.println(left + right + enter + back);
            }
        }
    }

}
