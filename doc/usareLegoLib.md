<style>
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}
</style>

# **Usare lego lib**

## indice

- Introduzione - pagina: 2
- Installazione - pagina: 2
- Com'&egrave; strutturato - pagina: 3
- Wait - pagina: 3
    - WaitTime - pagina: 4
- Strutture di controllo - pagina x

<div class="page-break"></div>

# introduzione
Lego lib &egrave; una libreria per controllare il brick Lego Mindstorm NXT con pi&ugrave;
facili&agrave;. Principalmente questa libreria &egrave; composta dai blocchi arancioni e da quelli
verdi del'ambiente sviluppo Mindstorm NXT.

- Bloccchi arancioni: Servono per aspettare che un determinato sensore legga un determinato valore
- Blocchi verdi: servono per la navigazione del robot

# Installazione

<div class="page-break"></div>

# Com&apos;&egrave; strutturato

Lego lib, principalmente è compreso di una libreria che rappresentano i blocchi arancioni e quelli
verdi dell'ambiente di sviluppo Mindstorm NXT.

## Blocchi arancioni
Servono per aspettare che un determinato sensore legga un determinato valore oppure rappresentano le
strutture di controllo di programmazione sequenziale.  
Per esempio aspettare che il sensore di luce riflessa legga un valore più alto del 50%.

I blocchi arancioni rappresentano i blcochi blocchi Wait, che in lego lib sono rappresentati dalle
 classi contenute nel package `legolib` che cominciano il loro nome con `Wait`.

Nei blocchi arancioni sono compresi anche le selezioni e i cicli, i quali sono implementati dalle
strutture di controllo `if (...) { ... }` e `while` o `do { ... } while` oppure `for (...) { ... }`.

## Wait

Tutte le classi hanno in comune hanno un costruttore che permette di inizializzare ogni wait con tutte le configurazioni possibili ed un metodo che fa eseguire lo wait.

![NXT Blocks](img/nxt-blocks/nxt-blocks.png)

### Sensori analogici

Gli waiter analogici si basano su una variabile contentente il valore di riferimento, questo valore
viene confrontato con quello letto dai sensori. Poi vi &egrave; una variabile boleana, la quale
viene utilizzata per sapere se il valore letto dal sensore deve essere maggiore o minore rispetto a
quello memorizzato nella variabile di riferimento.
Tutto questo &egrave; nella classe `WaitAnalogSensor`, la quale viene estesa dalle classi dei
sensori analogici.

Diagramma UML della classe `WaitAnalogSensor`:

<p style="text-align:center;">
    <img src="img/classes/WaitAnalogSensor.png" width="200">
</p>


<div class="page-break"></div>


### WaitTime

<div class="clearfix">
    <div style="float:left">
        <img style="width:65px" src="img/nxt-blocks/wait-time.png">
    </div>
    <div style="float:left;padding: 20px 0 0 10px; max-width:428px">
        Il blocco wait time dell'ambiente di sviluppo Mindstorm NXT è rappresentato dalla
        classe&nbsp;`WaitTime`, la quale permette di aspettare del tempo, in millisecondi.
    </div>
</div>

<br>
Il diagramma UML della classe:

<p style="text-align:center;">
    <img src="img/classes/WaitTime.png" width="200">
</p>

La classe WaitTime &egrave; stata fatta per mantenere la coerenza con le altre classi, ma pu&ograve; essere facilmente sostituita da un `Thread.sleep(millis);`.

Esempio di utilizzo della classe in maniera **asincrona**:

```java
import lejos.nxt.Button;

/**
 * Using WaitTime to test it.
 * Aspetta del tempo.
 *
 * @author gabrialessi
 * @author giuliobosco
 * @version 1.q (2019-02-05)
 */
public class UseWaitTime {

     /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitTime.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // creo lo wait time, con una attesa di 5000 millisecondi,
        // 5 secondi.
        WaitTime wt = new WaitTime(5000);

        // stamo il messaggio iniziale, "aspettando..."
        System.out.println("Aspettando...");

        // aspetto i 5000 millisecondi
        wt.waitTime();

        // stampo ilmessaggio finale
        System.out.println("Attesa terminata.");

        // aspetto che venga premuto un bottone sul brick per terminare
        // il programma
        Button.waitForAnyPress();
    }
}
```

<br>
Oppure al posto della classe WaitTime, come detto in precedenza si
pu&ograve; utilizzare il metodo `Thread.sleep(5000);`, che &egrave; un
metodo interno alle libreire di java.

```java
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
```


<div class="page-break"></div>


### Wait Motor

<div class="clearfix">
    <div style="float:left">
        <img style="width:65px" src="img/nxt-blocks/wait-motor.png">
    </div>
    <div style="float:left;padding: 20px 0 0 10px; max-width:428px">
        Il blocco wait motor dell'ambiente di sviluppo Mindstorm NXT è rappresentato dalla
        classe&nbsp;`WaitMotor`, la quale permette di aspettare del che il motore abbia effettuato
        un determinato numbero di rotazioni.
    </div>
</div>

<br>

Il diagramma UML della classe:

<p style="text-align:center;">
    <img src="img/classes/WaitMotor.png" width="300">
</p>

Esempio di utlizzo della classe:

```java
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
```

### Wait Touch Sensor

<div class="clearfix">
    <div style="float:left">
        <img style="width:65px" src="img/nxt-blocks/wait-touch.png">
    </div>
    <div style="float:left;padding: 20px 0 0 10px; max-width:428px">
        Il blocco wait touch dell'ambiente di sviluppo Mindstorm NXT è rappresentato dalla
        classe&nbsp;`WaitTouchSensor`, la quale permette di aspettare del che un sensore di touch,
        su una delle porte venga premuto, o rilasciato oppure cliccato, cioè cliccato e rilasciato.
    </div>
</div>

Il diagramma UML della classe:

<p style="text-align:center;">
    <img src="img/classes/WaitTouchSensor.png" width="300">
</p>

Per sceglirere quale delle 3 azioni, (Premuto, rilasciato o cliccato) aspettare bisosgna cambiare il
valore `CLICKED` nel costruttore dello waiter con:

- `PRESSED` per premuto
- `RELEASED` per rilasciato


Esempio di utlizzo della classe:

```java
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
        // un click del sensore.
        WaitTouchSensor wtc = new WaitTouchSensor(SensorPort.S1,
                WaitTouchSensor.CLICKED);

        // stampo messaggio iniziale
        System.out.println("cliccare il touch sensor sulla porta 1");

        // aspetto che venga cliccato il touch sensor
        wtc.waitTouch();

        // stampo messagigo finale
        System.out.println("touch sensor cliccato");

        // aspetto che venga premuto un bottone sul brick per terminare
        // il programma
        Button.waitForAnyPress();
    }
}
```

Per sceglirere quale delle 3 azioni, (Premuto, rilasciato o cliccato) aspettare bisosgna cambiare il
valore `CLICKED` nel costruttore dello waiter con:
- `PRESSED` per premuto
- `RELEASED` per rilasciato


### Wait NXT Button

<div class="clearfix">
    <div style="float:left">
        <img style="width:65px" src="img/nxt-blocks/wait-nxt-button.png">
    </div>
    <div style="float:left;padding: 20px 0 0 10px; max-width:428px">
        Il blocco wait nxt button dell'ambiente di sviluppo Mindstorm NXT è rappresentato dalla
        classe&nbsp;`WaitNxtButton`, la quale permette di aspettare del che venga premuto uno dei
        bottoni sul brick NXT.
    </div>
</div>

Il diagramma UML della classe:

<p style="text-align:center;">
    <img src="img/classes/WaitMotor.png" width="300">
</p>

Per ogni bottone vi è un metodo statico, per cui per far aspettare il click di un bottone
baster&agrave; richiamare il metodo.

- bottone sinistro: `WaitNxtButton.leftButton()`
- bottone di invio: `WaitNxtButton.enterButton()`
- bottone destro: `WaitNxtButton.rightButton()`
- bottone indietro: `WaitNxtButton.backButton()`

Esempio di utlizzo della classe:

```java
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

        // aspetto che venga premuto un bottone sul brick per terminare
        // il programma
        Button.waitForAnyPress();
    }
}
```

### Wait Ultrasonic Sensor

<div class="clearfix">
    <div style="float:left">
        <img style="width:65px" src="img/nxt-blocks/wait-touch.png">
    </div>
    <div style="float:left;padding: 20px 0 0 10px; max-width:428px">
        Il blocco wait touch dell'ambiente di sviluppo Mindstorm NXT è rappresentato dalla
        classe&nbsp;`WaitUltrasonicSensor`, la quale permette di aspettare del che un sensore di
        ultrasuoni percepisca un valore più alto o piu basso di un certo valore.
    </div>
</div>

Come descritto nel capitolo `Wait > Sensori Analogici` i valori di riferimento sono gestiti nella
classe `WaitAnalogSensor`.

Il diagramma UML della classe:

<p style="text-align:center;">
    <img src="img/classes/WaitSoundSensor.png">
</p>

Esempio di utlizzo della classe:

```java
import lejos.nxt.Button;
import lejos.nxt.SensorPort;

/**
 * Wait ultrasonic sensor example class.
 * Aspetta che il sensore ad ultrasuoni (distanza) sulla porta 1
 * legga un valore maggiore di 50cm, poi aspetta che venga premuto
 * un qualunque tasto sul brick, poi aspetta di leggere un valore
 * minore di 50cm sul sensore.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-01)
 */
public class UseWaitUltrasonicSensor {

    /**
     * Metodo main della classe, avvia il programma di test della classeπ
     * WaitUltrasonicSensor.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // creo lo waiter per il ultrasonic sensor sulla porta uno.
        WaitUltrasonicSensor wus = new WaitUltrasonicSensor(
                SensorPort.S1, (byte) 50, true);

        // stampo messaggio iniziale, aspetto che il sensore ad ultrasuoni
        // legga un valore maggiore di 50cm
        System.out.println(
                "mettere il sensore piu lontano di 50cm dal sensore");
        wus.waitUltrasonic();

        // aspetto che venga premuto un qualunque bottone sul brick
        Button.waitForAnyPress();

        // stampo messaggio intermedio, aspetto che il sensore ad
        // ultrasuoni legga un valore miniore di 50cm
        wus.setBigger(false);
        System.out.println(
                "mettere il sensore piu vicino di 50cm dal sensore");
        wus.waitUltrasonic();

        // stampo messaggio finale
        System.out.println("fine del test");

        // aspetto che venga premuto un bottone sul brick per terminare
        // il programma
        Button.waitForAnyPress();
    }
}
```

### Wait Light Sensor

<div class="clearfix">
    <div style="float:left">
        <img style="width:65px" src="img/nxt-blocks/wait-light.png">
    </div>
    <div style="float:left;padding: 20px 0 0 10px; max-width:428px">
        Il blocco wait touch dell'ambiente di sviluppo Mindstorm NXT è rappresentato dalla
        classe&nbsp;`WaitLightSensor`, la quale permette di aspettare del che un sensore di
        di suoni percepisca un valore più alto o piu basso di un certo valore.
    </div>
</div>

Come descritto nel capitolo `Wait > Sensori Analogici` i valori di riferimento sono gestiti nella
classe `WaitAnalogSensor`.

Il diagramma UML della classe:

<p style="text-align:center;">
    <img src="img/classes/WaitLightSensor.png">
</p>

Esempio di utlizzo della classe:

```java
import lejos.nxt.Button;
import lejos.nxt.SensorPort;

/**
 * Wait light sensor example class.
 * Aspetta che il sensore di intensita di luce riflessa collegato
 * alla porta 1 vegna messo su una superfice chiara, e poi scura.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-01)
 */
public class UseWaitLightSensor {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitLightSensor.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // creo lo waiter per il light sensor, sulla porta uno
        WaitLightSensor wls = new WaitLightSensor(
                SensorPort.S1, (byte)50, true);

        // stampo il messaggio iniziale e aspetto che il sensore
        // legga un valore alto piu alto di 50.
        System.out.println("Mettere su superficie chiara");
        wls.waitLight();

        Button.waitForAnyPress();

        // stampo il messaggio intermedio e aspetto che il sensore
        // legga un valore piu basso di 50.
        wls.setBigger(false);
        System.out.println("Mettere su superfice scura");
        wls.waitLight();

        // stampo messaggio finale
        System.out.println("Fine del test");

        // aspetto che venga premuto un bottone sul brick per terminare
        // il programma
        Button.waitForAnyPress();
    }
}
```

#### Calibrazione sensori

Per poter utilizzare in maniera ottimale i sensori, bisogna calibrarli con la luce attuale del'
ambiente circostante.  
Per calibrare i sensori bisogna settare la luce massima e la luce minima che pu&ograve; leggere il
sensore. La luce massima che un sensore pu&ograve; leggere solitamente &egrave; intesa come il
bianco, che riflette molta luce; mentre la luce minima che il sensore pu&ograve; leggere è il nero,
che riflette pochissima luce.

```java
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
```

<div class="page-break"></div>

### Wait Sound Sensor

<div class="clearfix">
    <div style="float:left">
        <img style="width:65px" src="img/nxt-blocks/wait-sound.png">
    </div>
    <div style="float:left;padding: 20px 0 0 10px; max-width:428px">
        Il blocco wait touch dell'ambiente di sviluppo Mindstorm NXT è rappresentato dalla
        classe&nbsp;`WaitSoundSensor`, la quale permette di aspettare del che un sensore di
        di suoni percepisca un valore più alto o piu basso di un certo valore.
    </div>
</div>

Come descritto nel capitolo `Wait > Sensori Analogici` i valori di riferimento sono gestiti nella
classe `WaitAnalogSensor`.

Il diagramma UML della classe:

<p style="text-align:center;">
    <img src="img/classes/WaitSoundSensor.png">
</p>

Esempio di utlizzo della classe:

```java
import lejos.nxt.Button;
import lejos.nxt.SensorPort;

/**
 * Wait sound sensor example class.
 * Aspetta che venga recepito un suono forte dal microfono
 * sulla porta 1.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-01)
 */
public class UseWaitSoundSensor {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitSoundSensor.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // creo lo waiter per il sound sensor sulla porta uno, che aspetta
        // un suono forte.
        WaitSoundSensor wss = new WaitSoundSensor(
                SensorPort.S1, (byte)50, true);

        // stampo messaggio iniziale
        System.out.println("parlare davanti al microfono");

        // aspetto che venga recepito un suono forte
        wss.waitSound();

        // stampo messaggio finale
        System.out.println(
                "Valore alto del microfono recepito");

        // aspetto che venga premuto un bottone sul brick per terminare
        // il programma
        Button.waitForAnyPress();
    }
}
```


## Strutture di controllo
<div class="clearfix">
    <div style="float:left">
        <img width="80" src="img/nxt-blocks/while.png">
    </div>
    <div style="float:left;; padding: 5px 0 0 30px">
        <p>
            La struttura di controllo del ciclo pu&ograve; essere rappresentata in diverse maniere:
        </p>
        <ul>
            <li>`while (...) { ... }`</li>
            <li>`do { ... } while (...)`</li>
            <li>`for (...) { ... }`</li>
        </ul>
    </div>
</div>

<br>

<div class="clearfix">
    <div style="float:left">
        <img width="80" src="img/nxt-blocks/if.png">
    </div>
    <div style="float:left; padding: 40px 0 0 30px">
        <p>
            La struttura di controllo del switch o selezione &egrave; in programmazione &egrave;<br> rappresentata dalla struttura di controllo `if (...) { ... }`
        </p>
    </div>
</div>


<div class="page-break"></div>

## Blocchi verdi

I blocchi verdi dell'ambiente di sviluppo Lego&#174; Mindstorm NXT sono quelli relativi agli
attuatori.  
Gli attuatori possono essere:

- motori
- schermi
- display
- led
- buzzer
- altoparlanti

Quindi sono tutti quegli elementi che collegati ad un cirtcuito di controllo, a dipendenza della
loro natura e dell'istruzione o segnale che gli viene invato, fanno dei movimenti, o modificano il
loro stato.

In questa libreria vi sono principalmente 2 classi di attuatori, perch&egrave; le altre gia sono
state implementate dalla libreria interna di lejos.

- Motore singolo
- Navigazione

La gestione dei motori è stata suddivisa in due classi differenti, una per il motore singolo mentre
l'altra per la navigazione a due motori (per navigazione si intende il movimento del robot con due
motori che lavorano in sincronia).

La gestione del display è gia implementata dalla classe `System.in`, mentre le funzioni audio sono
implementate nella classe `lejos.nxt.Sound`.

### Motore singolo

<div class="clearfix">
    <div style="float:left">
        <img style="width:65px" src="img/nxt-blocks/motor.png">
    </div>
    <div style="float:left;padding: 20px 0 0 10px; max-width:428px">
        Il blocco motor (per il motore singolo) dell'ambiente di sviluppo Mindstorm NXT è
        rappresentato dalla classe&nbsp;`SingleMotor`, la quale permette di gestire facilmente un
        motore.
    </div>
</div>

<br>

Il diagramma UML della classe:

<p style="text-align:center;">
    <img src="img/classes/SingleMotor.png" style="width:210px">
</p>

<div class="page-break"></div>

### Navigazione

<div class="clearfix">
    <div style="float:left">
        <img style="width:65px" src="img/nxt-blocks/motor.png">
    </div>
    <div style="float:left;padding: 20px 0 0 10px; max-width:428px">
        Il blocco motor (per la navigazione) dell'ambiente di sviluppo Mindstorm NXT è
        rappresentato dalla classe&nbsp;`Navigation`, la quale permette di manovrare con
        facilit&agrave; i motori.
    </div>
</div>

<br>

Il diagramma UML della classe:

<p style="text-align:center;">
    <img src="img/classes/Navigation.png" style="width:420px">
</p>

Per poter manovrare i motori bisogna settare la velocit&agrave; (con il metodo `setPower(power)`),
mentre per manovrare la direzione bisogna usare il metodo `setTurning(turning)`. Poi bisogna avviare
la navigazione con il metodo `startNaviagation()`, la quale pu&ograve; essere fermata con il metodo
`stopNavigation()`.
