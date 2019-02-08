# Libreria LEGO | Diario di lavoro - 25.01.2019
##### Gabriele Alessi, Giulio Bosco
### Canobbio, 25.01.2019

## Lavori svolti

Durante questa giornata ci è stato comunicato che la data di consegna è stata nuovamente posticipata di una settimana, quindi ciò cambierà il diagramma di Gantt consuntivo e avremo più tempo per fare i test e fare una documentazione migliore.  
Stiamo lavorando su un metodo per convertire la documentazione da markdown a PDF che illustreremo prossimamente.
Per il resto ci siamo concentrati sulla documentazione e la guida della del prodotto, visto che siamo ultimamente li abbiamo lasciati in secondo piano a causa dell'implementazione delle classi.  
La seguente è la definizione messa nella documentazione della classe WaitLightSensor:
```
Classe figlia di `WaitAnalogSensor` utile per aspettare fino a quando si legge un certo valore con un sensore di luce. L'implementazione della classe non ha molte differenze rispetto alla sua classe superiore, infatti bisogna leggere un valore che va comparato con quello impostato dall'utente e si decide se deve essere maggiore o minore.

- lightSensor: Attributo che rappresenta il sensore di luce.
- getLightSensor(): Metodo utile per ottenere il sensore di luce.
- setLightSensor(): Metodo che serve per impostare il sensore di luce.
- WaitLightSensor(): Metodo costruttore, istanzia un nuovo `WaitLightSensor` impostando se il valore letto deve essere maggiore di quello inserito (`bigger`), il valore da comparare (`value`) e il sensore o la porta del brick in cui è inserito il sensore.
- run(): Metodo principale in cui si aspetta il giusto valore letto dal sensore di luce.
```
Inoltre sono state eliminate dal progetto i componenti riguardanti il sensore di colore (WaitAnalogSensorRange) visto che ci siamo resi conto che quest'ultimo non è disponibile.  
Durante le prossime lezioni cercheremo di concludere definitivamente il capitolo di implementazione nella documentazione e iniziare a fare un po' di test.

|Orario        |Lavoro svolto					|
|--------------|--------------------------------|
|13:15 - 16:30 |Documentazione|

##  Problemi riscontrati e soluzioni adottate
Nessun problema riscontrato.
##  Punto della situazione rispetto alla pianificazione
In linea con la pianificazione.
## Programma di massima per la prossima giornata di lavoro
Documentazione, revisione codice e test delle classi.
