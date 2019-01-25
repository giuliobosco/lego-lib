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

# Com&apos;&egrave; strutturato

Lego lib, principalmente è compreso di una libreria che rappresentano i blocchi arancioni e quelli
verdi dell'ambiente di sviluppo Mindstorm NXT.

## Blocchi arancioni
Servono per aspettare che un determinato sensore legga un determinato valore oppure rappresentano le
strutture di controllo di programmazione sequenziale.  
Per esempio aspettare che il sensore di luce riflessa legga un valore più alto del 50%.

I blocchi arancioni rappresentano i blcochi blocchi Wait, che in lego lib sono rappresentati dalle
 classi contenute nel package`ch.ti.cpttrevano.samt.legolib.wait`.

Nei blocchi arancioni sono compresi anche le selezioni e i cicli, i quali sono implementati dalle
strutture di controllo `if (...) { ... }` e `while` o `do { ... } while` oppure `for (...) { ... }`.

### Wait

Il punto di forza di degli wait è che possono essere utilizzati in maniera sincrona, sia che in
maniera asincrona.  
Tutte le classi hanno in comune 3 metodi principali per il loro controllo:

- `beginWait()` serve per "aspettare" in mainera asincrona la condizione.
- `isFinished()` ritorna un valore boleano, `true` se la condizione è stata trovata altrimenti
    `false`.
- `waiter()` serve per aspettare in maniera sincrona, cio&egrave; quando viene richiamato questo
metodo il programma si ferma finch&eacute; la condizione non si avvera. (Richiama il metodo
    `beginWait()` entra in un ciclo nel quale aspetta 50ms, esce dal ciclo quando `isFinished()`
    ritorna true).

![NXT Blocks](img/nxt-blocks/nxt-blocks.png)

##### Wait Time

<div class="clearfix">
    <div style="float:left">
        <img width="120" src="img/nxt-blocks/wait-time.png">
    </div>
    <div style="float:left;; padding: 35px 0 0 30px; max-width:600px">
        Il blocco wait time dell'ambiente di sviluppo Mindstorm NXT è rappresentato dalla
        classe&nbsp;`WaitTime`, la quale permette di aspettare del tempo, in millisecondi.
    </div>
</div>

<br>
Il diagramma UML della classe:
![WaitTime UML diagram](img/classes/WaitTime.png)

<br>
Esempio di utilizzo della classe in maniera **asincrona**:
```java
import ch.ti.cpttrevano.samt.legolib.wait.WaitTime;
import lejos.nxt.Button;

/**
 * Wait time example class.
 * Questa classe crea un wait time con 2000 millisecondi di
 * attesa, poi stampa ogni 100 millisecondi "Aspetto..."
 * finché non finisce il tempo della wait time. Sfurtta la
 * funzione asincrona del classe.
 */
public class UseWaitTimeAsynchron {
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

        // aspetto che venga cliccato un qualunque tasto del
        // blocco NXT, questo perchè altrimenti il programma
        // terminerebbe subito e non si riuscirebbe a leggere
        // l'ultima cosa stampata.
		Button.waitForAnyPress();

    }
}
```

<br>
Esempio di utilizzo della classe in maniera **sincrona**:
```java
/**
 * Wait time example class.
 * Questa classe crea un wait time con 2000 millisecondi di
 * attesa, stampa "inizio", poi aspetta che lo wait termini
 * e stampa "finito".
 */
 public class UseWaitTimeSynchron {
     public static void main(String[] args) {
         // creo il wait time con 2000 millisecondi di attesa
         WaitTime wt = new WaitTime(2000);

         // stampo inizio
         System.out.println("inizio");

         // aspetto i 2000 millisecondi
         wt.waiter();

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
    <div style="float:left; padding: 40px 0 0 30px; max-width:600px">
        <p>
            La struttura di controllo del switch o selezione &egrave; in programmazione
            &egrave; rappresentata dalla struttura di controllo `if (...) { ... }`
        </p>
    </div>
</div>
