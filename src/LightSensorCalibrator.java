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

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

/**
 * Calibrate the light sensor.
 * Calibra il sensore di luce, con la luce che presente nel luogo
 * dov'&egrave; il sensore.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-06)
 */
public class LightSensorCalibrator {

    /**
     * Metodo main della classe, permette di calibrare il sensore
     * di luce.
     *
     * @param args Comm
     */
    public static void main(String[] args) {
        // setto il sensore di luce su cui eseguire la calibrazione
        LightSensor ls = new LightSensor(SensorPort.S1);

        // scrivo il messaggio per avvertire l'utente di mettere il
        // sensore di luce su una superfice bianca (o chiara)
        System.out.println(
                "Posizionare il sensore sul bianco. " +
                        "Poi premere Enter");

        // aspetto che venga premuto il bottone enter
        WaitNxtButton.enterButton();

        // calibro il massimo di luce letta sul senore
        ls.calibrateHigh();

        // pulisco il sensore del brick NXT
        System.out.println("\n\n\n\n\n\n\n\n\n");

        // scrivo il messaggio per avvertire l'utente di mettere il
        // sensore di luce su una superfice scura (o nera)
        System.out.println("Posizionare il sensore sul nero. Poi premere Enter.");

        // aspetto che venga premuto il bottone enter
        WaitNxtButton.enterButton();

        // calibro il minimo di luce letta sul sensore
        ls.calibrateLow();
    }
    
}
