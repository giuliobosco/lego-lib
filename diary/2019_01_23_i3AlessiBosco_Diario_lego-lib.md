# Libreria LEGO | Diario di lavoro - 23.01.2019
##### Gabriele Alessi, Giulio Bosco
### Canobbio, 23.01.2019

## Lavori svolti

La scorsa settimana abbiamo finito di implementare le classi, quindi oggi cominceremo con i test modulari e proseguiremo con la documentazione. Nel frattempo guarderemo le classi che stiamo testando per perfezionare eventualmente qualcosa e mettere in ordine il codice e la Javadoc.  
Il seguente è lo stile adottato per il codice e la Javadoc:
```
/*
 * The MIT License
 *
 * Copyright 2019 SAMT.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * ...
 */

package ch.ti.cpttrevano.samt.legolib.wait;

/**
 * Wait class, used to generalize all waiting classes.
 * In the LEGO Mindstorms environment is represented by the orange block "Wait".
 *
 * @author giuliobosco
 * @author gabrialessi
 * @version 1.1
 */
public class Wait extends Thread {

    // ------------------------------------------------------------------------- Constants

    ...

    // ------------------------------------------------------------------------- Fields
    
    ...

    // ------------------------------------------------------------------------- Getters
    
    int getValue() { return ... }
    
    // ------------------------------------------------------------------------- Setters
    
    void setValue(value) { ... }

    // ------------------------------------------------------------------------- Constructors
    
    Wait(field1, field2) { ... }

    // ------------------------------------------------------------------------- Help Methods

    ...
    
    // ------------------------------------------------------------------------- General Methods
    
    ...
    
}
```
Poi è stato creato il package per i test delle classi, questa è la struttura delle classi di test:
```
public class WaitTouchSensorTest {

    public static void main(String[] args) {

        // Set a new touch sensor on port 1
        TouchSensor touch = new TouchSensor(SensorPort.S1);

        // Set the wait action to 2 (CLICKED)
        byte action = 2;

        // New wait for the touch sensor
        WaitTouchSensor wait = new WaitTouchSensor(touch, action);

        // Start the wait
        wait.start();
    }
}
```
Nel frattempo stiamo anche lavorando nella creazione della guida per utilizzare il prodotto.

|Orario        |Lavoro svolto					|
|--------------|------------------------------	|
|13:15 - 14:45 |Documentazione e test|

##  Problemi riscontrati e soluzioni adottate
È stato riscontrato un problema riguardo l'import dei package nelle classi per fare i test. La prossima volta si troverà una soluzione e si definirà come eseguire i test e dove mettere i file generati dai test.
##  Punto della situazione rispetto alla pianificazione
In linea con la pianificazione.
## Programma di massima per la prossima giornata di lavoro
Documentazione, revisione codice e test delle classi.