# Libreria LEGO

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
        - [Componenti](#componenti)
            - [Sensori](#sensori)
            - [Attuatori](#attuatori)
    - [Design procedurale](#design-procedurale)
        - [Diagramma delle classi](#diagramma-delle-classi)

4. [Implementazione](#implementazione)
    - [Classi](#classi)
        - [HelloWorld](#helloworld)
            - [Test](#test)
        - [LineFollower](#linefollower)
            - [Test](#test)

5. [Test](#test)
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
Data fine: 01.02.2019

### Abstract

> *In questo documento è descritto come abbiamo sviluppato il prodotto"Libreria LEGO":  
> una libreria sviluppata in Java utile per automatizzare le operazioni più comuni durante la
> programmazione di robot LEGO&reg;.  
> Ad esempio la lettura dei dati ricevuti da un sensore o le operazioni di
> movimento con degli attuatori.  
> Queste librerie verranno utilizzate principalmente dagli informatici della classe
> seconda della Scuola d'Arti e Mestieri di Trevano per implementare i programmi per la
> WRO (World Robot Olympiad) e FLL (First LEGO League).  
> Questa raccolta di funzioni permetterà agli utenti di focalizzarsi maggiormente
> sul problema principale da risolvere avendo già le operazioni di base
> implementate e testate.*

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

#### Componenti

I componenti possono essere di due tipi, sensori ed attuatori.  
Per ogni sensore ci deve essere un metodo per la lettura dei dati letti dal sensore. Mentre gli attuatori devono avere dei metodi per il loro controllo e delle funzioni che ricavano dei dati in base ai movimenti effettuati. Per esempio il conteggio di rotazioni del motore durante un'azione.

##### Sensori

- Light, misura l'intensità di luce riflessa:
    - calibrateWhite()  
    questo metodo calibra il bianco all'intensità di luce riflessa in quell'instante.
    - calibrateBlack()  
    questo metodo calibra il nero all'intensità di luce riflessa in quell'instante.
    - getValue()  
    ritorna il valore di luce riflessa, un valore fra 0 e 100, 0 sarebbe bainco e 100 nero.
- Distance, misura la distanza fra il sensore e l'ostacolo davanti a esso:
    - getValue()  
    ritorna il valore letto dal sensore.
- Microphone, misura il suono:
    - getValue()  
    Ritorna il valore registrato dal microfono.
- Touch, controlla semplicemente se è premuto il sensore:
    - getValue()  
    Ritorna `true` se è premuto, altrimenti `false`.
- BrickButtons, legge i pulsanti presenti sul brick:

##### Attuatori

- LargeMotor, il motore più potente per i LEGO&reg; Mindstorms:
    - forward()  
    Fa girare il motore in avanti.
    - reverse()  
    Fa girare il motore indietro.
    - stop()  
    Ferma il motore.
    - invert()  
    Inverte il senso dei motori (avanti <=> indietro).
    - getValue()  
    Ritorna i gradi di rotazione attuale (0 - 360).
- LCD, è lo schermino che si trova sul brick:

### Design procedurale

In questa sezione è descritto come sono strutturate le cartelle contententi la libreria sviluppata.

- src
    - ch
        - ti
            - cpttrevano
                - samt
                    - legolib
                        - examples
                            - LineFollower.java
                        - motor
                            - Motor.java
                        - wait
                            - Wait.java
    - test
        - HelloWorld.java
        - LineFollower.java

#### Diagramma delle classi

![Diagramma delle classi](img/lego-lib-uml.png)

## Implementazione

Il capitolo di implementazione mostra in poche parole la messa in atto della progettazione. Tutte le classi presenti nel diagramma vengono qui spiegate più nel dettaglio illustrando i metodi e le parti di codice tramite screenshots o rappresentazioni o schemi e tabelle.

### Classi

#### HelloWorld

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

##### Test

Per verificare il giusto funzionamento della classe l'abbiamo caricata sul brick e l'abbiamo avviata attraverso i comandi spiegati nella guida [InstallWindows](installWindows.md).  
Questo è il risultato ottenuto:

<img src="img/helloworld_test.png" width=200>

#### LineFollower

##### Test

## Test

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
