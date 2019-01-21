# Usare lego lib
Lego lib &egrave; una libreria per controllare il brick Lego Mindstorm NXT con pi&ugrave;
facili&agrave;. Principalmente questa libreria &egrave; composta dai blocchi arancioni e da quelli verdi del'ambiente sviluppo Mindstorm, i quali servono per "aspettare dei valori dai sensori".

- Bloccchi arancioni: Servono per aspettare che un determinato sensore legga un determinato valore.
- Blocchi verdi: servono per la navigazione del robot.

## Installazione

## Com&apos;&egrave; strutturato

Lego lib, principalmente è compreso di una libreria che rappresentano il arancione dell'ambiente di
sviluppo Mindstorm NXT. Cio&egrave; il blocco "Wait", questo pu&ograve; essere utilizzato in maniera
sincrona (con il metodo `waiter()`) oppure in maniera asincrona (con i metodi `beginWait()` e
`isFinished()`).

Per creare uno waiter gli si passano i parametri richiesti dal costruttore durante l'istanziazione,
oppure con i metodi setter, i quali per&ograve; potranno settare i valori solo nel caso lo waiter
non è avviato.
