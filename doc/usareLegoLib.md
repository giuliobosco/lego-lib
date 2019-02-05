<style>
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}
</style>

# **Usare lego lib**
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

### Wait

Tutte le classi hanno in comune hanno un costruttore che permette di inizializzare ogni wait con tutte le configurazioni possibili ed un metodo che fa eseguire lo wait. 

![NXT Blocks](img/nxt-blocks/nxt-blocks.png)


<div class="page-break"></div>

##### Wait Time

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

<img src="img/classes/WaitTime.png">

<br>

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

##### Wait Motor

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

Il diagramma UML della classe:

<img src="img/classes/WaitMotor.png">

Esempio di utlizzo della classe in maniera **asincrona**:

```java
import lejos.nxt.Button;

/**
 * Wait time example class.
 * Questa classe crea un wait con l'attesa di 5 rotazioni del motore sulla
 * porta A, poi stampa ogni 100 millisecondi "Aspetto..." finch&eacute; il
 * motore esegue tutte le rotazioni che deve eseguire. Sfurtta la funzione
 * asincrona della classe.
 */
public class UseWaitMotorAsynchron {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitMotor in maniera asincrona.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {
        // Creo lo waiter settato per le 5 rotazioni ed il motore sulla
        // porta A
        WaitMotor wm = new WaitMotor(new SingleMotor('A'), 5);

        // aspetto che il motore esegua le 5 rotazioni mentre
        // stampo "Aspetto..." ogni 100 ms
        while (!wm.isFinished()) {
            // stampo "Aspetto..."
            System.out.println("Aspetto...");

            // aspetto 100 millisecondi
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {

            }
        }

        // Stampa "finito"
        System.out.println("finito");

        // aspetto che venga cliccato un qualunque tasto del blocco NXT,
        // questo perchè altrimenti il programma terminerebbe subito e non
        // si riuscirebbe a leggere l'ultima cosa stampata.
        Button.waitForAnyPress();
    }
}
```

Esempio di utlizzo della classe in maniera **sincrona**:

```java
import lejos.nxt.Button;

/**
 * Wait motor example class.
 * Questa classe crea uno wait con l'attesa di 5 roatazioni del motore sulla
 * porta A, poi stampa inizio e poi finito quando il motore ha eseguito 5
 * rotazioni.
 */
public class UseWaitMotorSynchron {

    /**
     * Metodo main della classe, avvia il programma di test della classe
     * WaitMotor in maniera sincrona.
     *
     * @param args Argomenti da linea di comando.
     */
    public static void main(String[] args) {}
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
```


### Strutture di controllo
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
