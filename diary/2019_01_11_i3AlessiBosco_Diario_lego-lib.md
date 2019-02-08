# Libreria LEGO | Diario di lavoro - 11.01.2019
##### Gabriele Alessi, Giulio Bosco
### Canobbio, 11.01.2019

## Lavori svolti

Durante questa giornata abbiamo continuato con l'implementazione del progetto.  
Ci siamo concentrati sulle classi WaitSensor, che sono composte fondamentalmente da un attributo che identifica il sensore e dei metodi generali che permettono di ricavarne il valore/stato. Inoltre vengono utilizzati metodi che vengono dal pacchetto `lejos.nxt`:
```
this.getTouchSensor().isPressed()
```
Il metodo `isPressed()` ritorna `true` o `false` se il sensore di pressione è premuto o meno.  
Questo è un link che è stato utile per capire meglio il funzionamento dei sensori: [http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/LCD_Sensors.htm](http://www.lejos.org/nxt/nxj/tutorial/LCD_Sensors/LCD_Sensors.htm).  
Qui di seguito c'è il metodo di esecuzione principale del sensore di pressione:
```
public void run() {
        while (this.isFinished()) {
            try {
                if (this.getWaitAction() == PRESSED) {
                    this.setFinished(this.getTouchSensor().isPressed());
                } else if (this.getWaitAction() == RELEASED) {
                    if (this.getTouchSensor().isPressed()) {
                        while (this.getTouchSensor().isPressed()) {
                            Thread.sleep(WAIT_TIME);
                        }

                        this.setFinished(true);
                    }
                } else if (this.getWaitAction() == CLICKED) {
                    if (!this.getTouchSensor().isPressed()) {
                        while (this.getTouchSensor().isPressed()) {
                            Thread.sleep(WAIT_TIME);
                        }

                        this.setFinished(true);
                    }
                }
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {

            }
        }
    }
```
Per quanto riguarda la documentazione siamo un po' fermi perché ci stiamo concentrando maggiormente sulla programmazione.  
Bisogna dire che la struttura delle classi sta prendendo forma e alcune cose sono cambiate rispetto alla progettazione iniziale, quindi prossimamente verrà caricato il diagramma delle classi definitivo.

|Orario        |Lavoro svolto					|
|--------------|--------------------------------|
|13:15 - 16:30 |Implementazione|

##  Problemi riscontrati e soluzioni adottate
Nessun problema riscontrato.
##  Punto della situazione rispetto alla pianificazione
In linea con la pianificazione.
## Programma di massima per la prossima giornata di lavoro
Continuazione implementazione metodi.
