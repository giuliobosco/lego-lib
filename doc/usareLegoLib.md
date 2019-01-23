<style>
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}
</style>

# Usare lego lib
Lego lib &egrave; una libreria per controllare il brick Lego Mindstorm NXT con pi&ugrave;
facili&agrave;. Principalmente questa libreria &egrave; composta dai blocchi arancioni e da quelli
verdi del'ambiente sviluppo Mindstorm NXT.

- Bloccchi arancioni: Servono per aspettare che un determinato sensore legga un determinato valore
- Blocchi verdi: servono per la navigazione del robot

## Installazione

## Com&apos;&egrave; strutturato

Lego lib, principalmente è compreso di una libreria che rappresentano i blocchi arancioni e quelli
verdi dell'ambiente di sviluppo Mindstorm NXT.

#### Blocchi arancioni
Servono per aspettare che un determinato sensore legga un determinato valore oppure rappresentano le
strutture di controllo di programmazione sequenziale.  
Per esempio aspettare che il sensore di luce riflessa legga un valore più alto del 50%.

I blocchi arancioni rappresentano i blcochi blocchi Wait, che in lego lib sono rappresentati dalle
 classi contenute nel package`ch.ti.cpttrevano.samt.legolib.wait`.

Nei blocchi arancioni sono compresi anche le selezioni e i cicli, i quali sono implementati dalle
strutture di controllo `if (...) { ... }` e `while` o `do { ... } while` oppure `for (...) { ... }`.

###### Wait

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

###### Strutture di controllo
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
