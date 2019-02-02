# Sistema didattico per LEGO EV3/NTX con libreria e documentazione

1. [Introduzione](#introduzione)
    - [Informazioni sul progetto](#informazioni-sul-progetto)
    - [Abstract](#abstract)
    - [Scopo](#scopo)

2. [Analisi](#analisi)
    - [Analisi del dominio](#analisi-del-dominio)
    - [Analisi e specifica dei requisiti](#analisi-e-specifica-dei-requisiti)
    - [Analisi dei mezzi](#analisi-dei-mezzi)
        - [Software](#software)
        - [Hardware](#hardware)
    - [Pianificazione](#pianificazione)

3. [Progettazione](#progettazione)
    - [Design dell’architettura del sistema](#design-dell’architettura-del-sistema)
        - [Design procedurale](#design-procedurale)
        - [Diagramma delle classi](#diagramma-delle-classi)
    - [Componenti](#componenti)
        - [Sensori](#sensori)
        - [Attuatori](#attuatori)

4. [Implementazione](#implementazione)
    - [WaitAnalogSensor](#waitanalogsensor)
        - [Test WaitAnalogSensor](#test-waitanalogsensor)
    - [WaitLightSensor](#waitlightsensor)
        - [Test WaitLightSensor](#test-waitlightsensor)
    - [WaitMotor](#waitmotor)
        - [Test WaitMotor](#test-waitmotor)
    - [WaitNxtButton](#waitnxtbutton)
        - [Test WaitNxtButton](#test-waitnxtbutton)
    - [WaitSoundSensor](#waitsoundsensor)
        - [Test WaitSoundSensor](#test-waitsoundsensor)
    - [WaitTime](#waittime)
        - [Test WaitTime](#test-waittime)
    - [WaitTouchSensor](#waittouchsensor)
        - [Test WaitTouchSensor](#test-waittouchsensor)
    - [WaitUltrasonicSensor](#waitultrasonicsensor)
        - [Test WaitUltrasonicSensor](#test-waitultrasonicsensor)
    - [HelloWorld](#helloworld)
        - [Test HelloWorld](#test-helloworld)

5. [Test di sistema](#test-di-sistema)
    - [Protocollo di test](#protocollo-di-test)
    - [Risultati test](#risultati-test)
    - [Mancanze/limitazioni conosciute](#mancanze/limitazioni-conosciute)

6. [Consuntivo](#consuntivo)

7. [Conclusioni](#conclusioni)
    - [Sviluppi futuri](#sviluppi-futuri)
    - [Considerazioni personali](#considerazioni-personali)

8. [Sitografia](#sitografia)

9. [Allegati](#allegati)

## Introduzione

### Informazioni sul progetto

- Allievi: Gabriele Alessi, Giulio Bosco  
Docenti e supervisori: Adriano Barchi, Luca Muggiasca, Francesco Mussi, Massimo Sartori
- Scuola d'Arti e Mestieri di Trevano, sezione Informatica, Classe 3, Modulo 306
- Data inizio: 14.11.2018  
Data fine: 08.02.2019

### Abstract

> In this document we describe how we developed the "LEGO Library" product: a library developed in 
> Java useful for automating the most common operations when programming LEGO robots. For example, 
> reading data received from a sensor or moving operations with actuators. These libraries will be 
> mainly used by the computer scientists of the second year class of the Trevano School of Arts and 
> Crafts to implement the programs for the WRO (World Robot Olympiad) and FLL (First LEGO League). 
> This collection of functions  will allow users to focus more on the main problem to be solved by 
> already having the basic operations implemented and tested.

### Scopo

Questo prodotto ha l'obiettivo di semplificare la parte di implementazione quando si sta sviluppando un progetto con dei robot LEGO&#174; Mindstorms. Il frutto del mandato comprende una libreria in grado di eseguire le funzioni più basilari e fondamentali che un robot deve svolgere durante una missione.

## Analisi

### Analisi del dominio

Fino a ora, gli allievi della sezione Informatica delle classi prima e seconda, implementavano manualmente anche le più semplici attività (seguire una linea, fermarsi di fronte a un ostacolo, ...) che i robot LEGO&#174; Mindstorms dovessero compiere. Quindi lo scopo di questo prodotto sarebbe quello di offrire una libreria che agevoli il lavoro degli utenti eliminando le parti di realizzazione più semplici e ripetitive. Il risultato sarà facile da utilizzare e lo sarà in varie situazioni, in quanto è sviluppato nel linguaggio Java.

### Analisi e specifica dei requisiti

La specifica dei requisiti del progetto è rappresentata tramite tabelle che definiscono le basi del prodotto. Le tabelle vengono elencate in base alla priorità e all'importanza del requisito.

|ID  |REQ-01                                          |
|----|------------------------------------------------|
|**Nome**    |Installazione del firmware|
|**Priorità**|1                     |
|**Versione**|2.0                   |
|**Note**    |È necessario installare il firmware leJOS (Java) su NXT.|
| *Sub-req 1* |Produrre una guida per l'installazione del firmware|

|ID  |REQ-02                                          |
|----|------------------------------------------------|
|**Nome**    |Verifica componenti|
|**Priorità**|1                     |
|**Versione**|2.1                   |
|**Note**    |È necessario testare ogni componente utilizzato durante la realizzazione del progetto.|
| *Sub-req 1* |Testare componenti (7 tra sensori e attuatori) su NXT con leJOS|

|ID  |REQ-03                                          |
|----|------------------------------------------------|
|**Nome**    |Componenti - Sensori|
|**Priorità**|1                     |
|**Versione**|2.1                   |
|**Note**    |Ogni sensore deve avere un metodo per la lettura del valore e se è possibile uno per calibrarlo.|
| *Sub-req 1* |Sensore di luce |
| *Sub-req 2* |Sensore tattile |
| *Sub-req 3* |Sensore a ultrasuoni (distanza) |
| *Sub-req 4* |Microfono |
| *Sub-req 5* |Pulsanti del brick |

|ID  |REQ-04                                          |
|----|------------------------------------------------|
|**Nome**    |Componenti - Attuatori|
|**Priorità**|1                     |
|**Versione**|2.0                   |
|**Note**    |Ogni attuatore deve avere dei metodi per controllarlo.|
| *Sub-req 1* |Motore Grande |
| *Sub-req 2* |Schermo LCD del brick |

|ID  |REQ-05                                          |
|----|------------------------------------------------|
|**Nome**    |LineFollower proporzionale|
|**Priorità**|1                     |
|**Versione**|2.0                   |
|**Note**    |È necessario implementare la funzione "LineFollower" in modo proporzionale e facile da utilizzare.|

### Analisi dei mezzi

#### Software

I software usati comprendono quelli presenti sui nostri PC e il firmware per il brick:
- leJOS: è una Java Virtual Machine adattata per i brick NXT e EV3.  
*Link:* [http://www.lejos.org/](http://www.lejos.org/)  
*Versione:* NXJ 0.9.1
- Visual Studio Code 1.29.1
- GitHub Desktop 1.5.0
- GanttProject 2.8.9 Pilsen
- StarUML 3.0.2
- NetBeans IDE 8.2
- Windows PowerShell ISE Host 5.1.17134.407

#### Hardware

Per la realizzazione del prodotto ci siamo serviti dei nostri computer portatili e di un brick:
- Apple MacBook Pro 15" 2018, Processore Intel&reg; Core I7, RAM 16GB, Disk 1TB SSD, Mac OS X 10.14.1
- HP ENVY Notebook, Intel&reg; Core I7, RAM 16GB, Windows 10 Home 64 bit
- Brick LEGO&reg; NXT

### Pianificazione

La pianificazione del progetto è stata effettuata mediante la realizzazione di un diagramma di Gantt.

![Diagramma di gantt](img/gantt.png)

## Progettazione

### Design dell’architettura del sistema

In questo settore viene spiegato come è stata ideata la struttura del sistema e in che modo i singoli componenti e moduli sono legati tra loro.

#### Design procedurale

Qui è descritto come sono strutturate le cartelle contententi la libreria sviluppata.

- src
    - out
    - test
        - HelloWorld.java
        - LineFollower.java
    - classes.jar
    - compile.ps1
    - LineFollower.java
    - Navigation.java
    - PLFRunner.java
    - ProportionalLineFollower.java
    - SingleMotor.java
    - Wait.java
    - WaitAnalogSensor.java
    - WaitDigitalSensor.java
    - WaitLightSensor.java
    - WaitMotor.java
    - WaitNxtButton.java
    - WaitSensor.java
    - WaitSoundSensor.java
    - WaitTime.java
    - WaitTouchSensor.java
    - WaitUltrasonicSensor.java

#### Diagramma delle classi

![Diagramma delle classi](img/lego-lib-uml.png)

#### Componenti

I componenti possono essere di due tipi, sensori ed attuatori.  
Per ogni sensore ci deve essere un metodo per la lettura dei dati letti dal sensore. Mentre gli attuatori devono avere dei metodi per il loro controllo e delle funzioni che ricavano dei dati in base ai movimenti effettuati. Per esempio il conteggio di rotazioni del motore durante un'azione.

##### Sensori

- *LightSensor*, misura l'intensità di luce riflessa.
- *UltrasonicSensor*, misura la distanza fra il sensore e l'ostacolo davanti a esso.
- *SoundSensor*, misura il suono (microfono).
- *TouchSensor*, controlla semplicemente se è premuto il sensore.
- *NxtButton*, legge i pulsanti presenti sul brick.

##### Attuatori

- *SingleMotor*, il motore più potente per i LEGO&reg; Mindstorms.
- *LCD*, è lo schermino che si trova sul brick.

## Implementazione

Il capitolo di implementazione mostra in poche parole la messa in atto della progettazione. Tutte le classi presenti nel diagramma vengono qui spiegate più nel dettaglio illustrando i metodi e le parti di codice tramite screenshots o rappresentazioni o schemi e tabelle.

L'implementazione del prodotto è composta da delle classi `Wait` che servono per aspettare che succeda qualcosa, ad esempio che un sensore legga un certo valore oppure aspettare del tempo. Ogni classe di questo tipo ha la sua classe di utilizzo, cioè del semplice codice utile per testare il corretto funzionamento dell'attesa. Poi ci sono le classi che permettono di controllare gli attuatori per muovere il robot (`SingleMotor`, `Navigation`). Infine ci sono le classi più importanti, dove più moduli vengono uniti per creare classi come `LineFollower` e `ProportionalLineFollower`.

### WaitAnalogSensor

Classe che serve per generalizzare le classi che aspettano un sensore analogico (microfono, tocco, ultrasuoni).

<img src="img/classes/waitanalogsensor.png" width=400>

- WAIT_TIME: Costante che definisce l'intervallo di tempo tra un controllo e un altro della fine dell'attesa.
- SENSOR_MIN_VALUE: Costante che definisce il minimo valore che un sensore può leggere.
- SENSOR_MAX_VALUE: Costante che definisce il massimo valore che un sensore può leggere.
- comparisonValue: Attributo che rappresenta il valore da comparare con quello letto dal sensore.
- bigger: Attributo che indica se il valore letto deve essere maggiore o minore di quello di confronto.
- getComparisonValue(): Metodo che serve per ottenere il valore di confronto.
- isBigger(): Metodo utile per sapere il valore dell'attributo `bigger`.
- setComparisonValue(): Metodo utile per impostare il valore di confronto.
- setBigger(): Metodo utile per impostare il valore dell'attributo `bigger`.
- WaitAnalogSensor(): Metodo costruttore, istanzia un nuovo `WaitAnalogSensor`, defininendo il campo `bigger` e il valore per comparare.

#### Test WaitAnalogSensor

### WaitLightSensor

Classe figlia di `WaitAnalogSensor` che aspetta che il sensore di luce percepisca un certo valore.

- lightSensor: Attributo che rappresenta il sensore di luce.
- getLightSensor(): Metodo che serve per ottenere il sensore.
- setLightSensor(): Metodo utile per impostare il sensore.
- WaitLightSensor(): Metodo costruttore, istanzia un nuovo `WaitLightSensor` impostando il valore di confronto, se il valore letto deve essere maggiore di quello di confronto e il sensore o la porta del brick in cui è inserito il sensore.
- waitLight(): È il metodo principale che termina l'attesa in base al valore di confronto.

#### Test WaitLightSensor

### WaitMotor

Classe che serve per aspettare che un motore faccia un certo numero di rotazioni.

- singleMotor: Attributo che rappresenta il motore grande (`SingleMotor`).
- comparisonValue: Attributo che rappresenta il valore da comparare con quello ricevuto dal motore.
- getSingleMotor(): Metodo che serve per ottenere il motore.
- getComparisonValue(): Metodo che serve per ottenere il valore di confronto.
- setSingleMotor(): Metodo utile per impostare il motore.
- setComparisonValue(): Metodo utile per impostare il valore di confronto.
- WaitMotor(): Metodo costruttore, istanzia un nuovo `WaitMotor` impostando il motore e il valore di confronto.
- waitMotor(): È il metodo principale che termina l'attesa quando il motore raggiunge le rotazioni determinate.

#### Test WaitMotor

### WaitNxtButton

#### Test WaitNxtButton

### WaitSoundSensor

Classe figlia di `WaitAnalogSensor` che aspetta che il microfono percepisca un certo valore.

- soundSensor: Attributo che rappresenta il sensore di suono (microfono).
- getSoundSensor(): Metodo che serve per ottenere il microfono.
- setSoundSensor(): Metodo utile per impostare il microfono.
- WaitSoundSensor(): Metodo costruttore, istanzia un nuovo `WaitSoundSensor` impostando il valore di confronto, se il valore letto deve essere maggiore di quello di confronto e il sensore o la porta del brick in cui è inserito il sensore.
- waitSound(): È il metodo principale che termina l'attesa in base al valore di confronto.

#### Test WaitSoundSensor

### WaitTime

#### Test WaitTime

### WaitTouchSensor

Classe utile per aspettare la pressione, il rilascio o il click di un sensore di tocco.  

<img src="img/classes/waittouchsensor.png" width=400>

- WAIT_TIME: Costante che definisce l'intervallo di tempo tra un controllo e un altro della fine dell'attesa.
- PRESSED: Costante che definisce la pressione del sensore.
- RELEASED: Costante che definisce il rilascio del sensore.
- CLICKED: Costante che definisce il click (pressione e rilascio) del sensore.
- touchSensor: Attributo che rappresenta il sensore di tocco.
- waitAction: Attributo che rappresenta l'azione da aspettare (premuto, rilasciato o cliccato).
- finished: Attributo interno che dice se l'attesa è finita.
- getTouchSensor(): Metodo che serve per ottenere il sensore di tocco.
- getWaitAction(): Metodo che serve per ottenere l'azione che si vuole aspettare.
- setTouchSensor(): Metodo utile per impostare il sensore di tocco.
- setWaitAction(): Metodo utile per impostare l'azione da aspettare.
- WaitTouchSensor(): Metodo costruttore, istanzia un nuovo `WaitTouchSensor` impostando l'azione (premuto, rilasciato, cliccato) e il sensore o la porta del brick in cui è inserito il sensore.
- isWaitAction(): Metodo utile per verificare che l'azione da aspettare imposta sia valida.
- isPressedButton(): Metodo che dice se il sensore è premuto.
- buttonPressedAction(): Metodo che aspetta la pressione del sensore.
- buttonReleasedAction(): Metodo che aspetta il rilascio del sensore.
- buttonClickedAction(): Metodo che aspetta il click (pressione e rilascio) del sensore.
- waitTouch(): È il metodo principale che termina l'attesa in base all'azione impostata.

#### Test WaitTouchSensor

### WaitUltrasonicSensor

Classe figlia di `WaitAnalogSensor` che aspetta che il sensore a ultrasuoni percepisca un certo valore.

- ultrasonicSensor: Attributo che rappresenta il sensore a ultrasuoni.
- getUltrasonicSensor(): Metodo che serve per ottenere il sensore.
- setUltrasonicSensor(): Metodo utile per impostare il sensore.
- WaitUltrasonicSensor(): Metodo costruttore, istanzia un nuovo `WaitUltrasonicSensor` impostando il valore di confronto, se il valore letto deve essere maggiore di quello di confronto e il sensore o la porta del brick in cui è inserito il sensore.
- waitUltrasonic(): È il metodo principale che termina l'attesa in base al valore di confronto.

#### Test WaitUltrasonicSensor

### HelloWorld

Questa classe è stata usata come test per iniziare a capire come implementare un programma Java in un brick NXT e per essere usata come esempio nella guida per configurare leJOS su Windows. È presente solo il metodo `main` con due classiche funzioni che insieme formano semplicemente l'output "Hello World".
```
import lejos.nxt.Button;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World");
		Button.waitForAnyPress();
	}
}
```

#### Test HelloWorld

Per verificare il giusto funzionamento della classe l'abbiamo caricata sul brick e l'abbiamo avviata attraverso i comandi spiegati nella guida [InstallWindows](installWindows.md).  
Questo è il risultato ottenuto:

<img src="img/helloworld_test.png" width=200>

## Test di sistema

### Protocollo di test

Definire in modo accurato tutti i test che devono essere realizzati per
garantire l’adempimento delle richieste formulate nei requisiti. I test
fungono da garanzia di qualità del prodotto. Ogni test deve essere
ripetibile alle stesse condizioni.


|Test Case      | TC-001                               |
|---------------|--------------------------------------|
|**Nome**       |Import a card, but not shown with the GUI |
|**Riferimento**|REQ-012                               |
|**Descrizione**|Import a card with KIC, KID and KIK keys with no obfuscation, but not shown with the GUI |
|**Prerequisiti**|Store on local PC: Profile\_1.2.001.xml (appendix n\_n) and Cards\_1.2.001.txt (appendix n\_n) |
|**Procedura**     | - Go to “Cards manager” menu, in main page click “Import Profiles” link, Select the “1.2.001.xml” file, Import the Profile - Go to “Cards manager” menu, in main page click “Import Cards” link, Select the “1.2.001.txt” file, Delete the cards, Select the “1.2.001.txt” file, Import the cards |
|**Risultati attesi** |Keys visible in the DB (OtaCardKey) but not visible in the GUI (Card details) |


### Risultati test

Tabella riassuntiva in cui si inseriscono i test riusciti e non del
prodotto finale. Se un test non riesce e viene corretto l’errore, questo
dovrà risultare nel documento finale come riuscito (la procedura della
correzione apparirà nel diario), altrimenti dovrà essere descritto
l’errore con eventuali ipotesi di correzione.

### Mancanze/limitazioni conosciute

Descrizione con motivazione di eventuali elementi mancanti o non
completamente implementati, al di fuori dei test case. Non devono essere
riportati gli errori e i problemi riscontrati e poi risolti durante il
progetto.

## Consuntivo

Consuntivo del tempo di lavoro effettivo e considerazioni riguardo le
differenze rispetto alla pianificazione (cap 1.7) (ad esempio Gannt
consuntivo).

## Conclusioni

Quali sono le implicazioni della mia soluzione? Che impatto avrà?
Cambierà il mondo? È un successo importante? È solo un’aggiunta
marginale o è semplicemente servita per scoprire che questo percorso è
stato una perdita di tempo? I risultati ottenuti sono generali,
facilmente generalizzabili o sono specifici di un caso particolare? ecc

### Sviluppi futuri
  Migliorie o estensioni che possono essere sviluppate sul prodotto.

### Considerazioni personali
  Cosa ho imparato in questo progetto? ecc

## Bibliografia

### Bibliografia per articoli di riviste
1.  Cognome e nome (o iniziali) dell’autore o degli autori, o nome
    dell’organizzazione,

2.  Titolo dell’articolo (tra virgolette),

3.  Titolo della rivista (in italico),

4.  Anno e numero

5.  Pagina iniziale dell’articolo,

### Bibliografia per libri


1.  Cognome e nome (o iniziali) dell’autore o degli autori, o nome
    dell’organizzazione,

2.  Titolo del libro (in italico),

3.  ev. Numero di edizione,

4.  Nome dell’editore,

5.  Anno di pubblicazione,

6.  ISBN.

### Sitografia

1.  URL del sito (se troppo lungo solo dominio, evt completo nel
    diario),

2.  Eventuale titolo della pagina (in italico),

3.  Data di consultazione (GG-MM-AAAA).

**Esempio:**

-   http://standards.ieee.org/guides/style/section7.html, *IEEE
    Standards Style Manual*, 07-06-2008.

## Allegati

Elenco degli allegati, esempio:

-   Diari di lavoro

-   Codici sorgente/documentazione macchine virtuali

-   Istruzioni di installazione del prodotto (con credenziali
    di accesso) e/o di eventuali prodotti terzi

-   Documentazione di prodotti di terzi

-   Eventuali guide utente / Manuali di utilizzo

-   Mandato e/o Qdc

-   Prodotto

-   …
