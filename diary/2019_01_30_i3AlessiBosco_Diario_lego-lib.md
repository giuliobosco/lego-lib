# Libreria LEGO | Diario di lavoro - 30.01.2019
##### Gabriele Alessi, Giulio Bosco
### Canobbio, 30.01.2019

## Lavori svolti

Durante questa giornata abbiamo lavorato su documentazione, guida del prodotto e test modulari.  
Durante le prime due ore abbiamo capito come scrivere il codice di test e come effettivamente testarlo sul brick. Mentre nelle seconde ore è saltato fuori un problema riguardo la classe WaitTime, che non riesce a fare il confronto con i tempi per fare un concreto wait ed essere in grado di utilizarrli in modo sincrono e asincrono.  
Questo è il metodo della classe WaitTime su cui abbiamo lavorato di più e abbiamo modificato per vedere quale fosse il problema:
```
public void run() {
        this.setStartTime(System.currentTimeMillis());
        this.setFinished(false);
        System.out.println(this.getStartTime());
        while (!this.isFinished()) {
            try {
            System.out.print(System.currentTimeMillis()+" ");
                System.out.println(this.getStartTime() + this.getWaitTime());
                this.setFinished(
                        this.getStartTime() + this.getWaitTime() >= System.currentTimeMillis());
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }
```


|Orario        |Lavoro svolto					|
|--------------|------------------------------	|
|13:15 - 16:30 |Documentazione e test|

##  Problemi riscontrati e soluzioni adottate
Abbiamo risconstrato un problema riguardo i test delle classi, visto che la struttura del sistema è stata composta da vari package in modo da seguire gli standard di Java. Quindi abbiamo deciso di eliminare i package così da semplificare la procedura di test.

Abbiamo riscontrato anche dei problemi nelle comparazioni, tutti i tipi di copmarazioni non lavorano correttamente
##  Punto della situazione rispetto alla pianificazione
Da recuperare il tempo perso con i test, è necessario accelerare su alcune cose, quindi probabilmente si lavorerà un po' al di fuori delle ore di lavoro.


https://stackoverflow.com/questions/29899270/java-lejos-autonomous-nxj-robot-threads-causing-trouble
Su questa pagina abbiamo scoperto che i NXT hanno problemi usando le threads.
## Programma di massima per la prossima giornata di lavoro
Documentazione e test delle classi.

Provare ad eseguire del codice senza thread.
