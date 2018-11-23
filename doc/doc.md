# Libreria LEGO

1. [Introduzione](#introduzione)
    - [Informazioni sul progetto](#informazioni-sul-progetto)
    - [Abstract](#abstract)
    - [Scopo](#scopo)

1. [Analisi](#analisi)
    - [Analisi del dominio](#analisi-del-dominio)
    - [Analisi dei mezzi](#analisi-dei-mezzi)
    - [Analisi e specifica dei requisiti](#analisi-e-specifica-dei-requisiti)
    - [Pianificazione](#pianificazione)

1. [Progettazione](#progettazione)
    - [Design dell’architettura del sistema](#design-dell’architettura-del-sistema)
    - [Design dei dati e database](#design-dei-dati-e-database)

1. [Implementazione](#implementazione)

1. [Test](#test)
    - [Protocollo di test](#protocollo-di-test)
    - [Risultati test](#risultati-test)
    - [Mancanze/limitazioni conosciute](#mancanze/limitazioni-conosciute)

1. [Consuntivo](#consuntivo)

1. [Conclusioni](#conclusioni)
    - [Sviluppi futuri](#sviluppi-futuri)
    - [Considerazioni personali](#considerazioni-personali)

1. [Sitografia](#sitografia)

1. [Allegati](#allegati)


## Introduzione

### Informazioni sul progetto

  -   Allievi: Gabriele Alessi, Giulio Bosco

      Docenti e supervisori: Adriano Barchi, Luca Muggiasca, Francesco Mussi

  -   Scuola d'Arti e Mestieri di Trevano, sezione Informatica, Classe 3, Modulo 306

  -   Data inizio: 14.11.2018

      Data fine: 25.01.2019

### Abstract

  > *In questo documento è descritto come abbiamo sviluppato il prodotto "Libreria
  > LEGO", cioè delle librerie utili per automatizzare le operazioni più comuni. Ad
  > esempio la lettura dei dati ricevuti da un sensore, oppure le operazioni di
  > movimento con degli attuatori.  
  > Queste librerie verranno utilizzate principalmente dagli aglievi della classe
  > seconda della Scuola d'Arti e Mestieri di Trevano per sviluppare i programmi per la
  > WRO (World Robot Olympiad) e FLL (First LEGO League). Questa raccolta di funzioni
  > permetterà agli utenti di focalizzarsi
  > sul problema principale da risolvere avendo già le operazioni di base
  > implementate e testate.*

### Scopo

  Questo prodotto ha l'obiettivo di semplificare la parte di implementazione quando si sta sviluppando un progetto con dei robot LEGO&#174; Mindstorms. Il frutto del mandato comprende delle librerie in grado di eseguire le funzioni più basilari e fondamentali che un robot deve svolgere durante una missione.

## Analisi

### Analisi del dominio

  Fino a ora, gli allievi della sezione Informatica delle classi prima e seconda, implementavano manualmente anche le più semplici attività (seguire una linea, fermarsi di fronte a un ostacolo, ...) che i robot LEGO&#174; Mindstorms dovessero compiere. Quindi lo scopo di questo prodotto sarebbe quello di offrire una libreria che agevoli il lavoro degli utenti eliminando le parti di realizzazione più semplici e ripetitive. Il risultato sarà facile da utilizzare e lo sarà in varie situazioni, in quanto è sviluppato in due linguaggi ed è compatibile sia con EV3 che con NXT.

### Analisi e specifica dei requisiti

  La specifica dei requisiti del progetto può essere rappresentata tramite tabelle che definiscono le basi del prodotto. Le tabelle vengono elencate in base alla priorità e all'importanza del requisito.

  |ID  |REQ-01                                          |
  |----|------------------------------------------------|
  |**Nome**    |Installazione dei firmware   |
  |**Priorità**|1                     |
  |**Versione**|1.0                   |
  |**Note**    |Per ognuna di queste installazioni ci vuole una guida dettagliata.|
  | *Sub-req 1* |Installare firmware RoboC su NXT|
  | *Sub-req 2* |Installare firmware RoboC su EV3|
  | *Sub-req 3* |Installare firmware leJOS su NXT|
  | *Sub-req 4* |Installare firmware leJOS su EV3|

  |ID  |REQ-02                                          |
  |----|------------------------------------------------|
  |**Nome**    | Verifica componenti   |
  |**Priorità**|1                     |
  |**Versione**|1.0                   |
  |**Note**    |È necessario testare ogni componente utilizzato durante la realizzazione del progetto.|
  | *Sub-req 1* |Testare componenti su NXT con RoboC|
  | *Sub-req 2* |Testare componenti su EV3 con RoboC|
  | *Sub-req 3* |Testare componenti su NXT con leJOS|
  | *Sub-req 4* |Testare componenti su EV3 con leJOS|

  |ID  |REQ-03                                          |
  |----|------------------------------------------------|
  |**Nome**    | Metodi componenti  |
  |**Priorità**|1                     |
  |**Versione**|1.0                   |
  |**Note**    | Ogni componente deve avere un metodo per utilizzarlo |
  | *Sub-req 1* | Metodo di calibrazione |
  | *Sub-req 1* | Metodo di controllo componente |

  |ID  |REQ-04                                          |
  |----|------------------------------------------------|
  |**Nome**    | Combinazioni Componenti  |
  |**Priorità**|1                     |
  |**Versione**|1.0                   |
  |**Note**    | Sono necessarie le combinazioni maggiormente utilizzate. |
  | *Sub-req 1* | LineFollower |
  | *Sub-req 2* | Explorer |
  | *Sub-req 3* | KeepDistance |
  | *Sub-req 4* | StopOnLine |
  | *Sub-req 5* | Rotations |
  | *Sub-req 6* | LCD |

### Pianificazione

La pianificazione può essere rappresentata mediante un diagramma di
Gantt.

![Diagramma di gantt](img/gantt.png)

### Analisi dei mezzi

Per questo progetto abbiamo a disposizione 1 brick Lego NXT e un brick Lego EV3, sui quali verranno istallati i firmware di RobotC e LeJOS.

- **RobotC** è una versione di C semplificata ed adattata per la programmazione dei
Robot.  
*Link:* [http://www.robotc.net/download/lego/](http://www.robotc.net/download/lego/)  
*Versione:* 4.56
- **LeJOS** è una Java Virtual Machine adattata per i brick NXT e EVT3.  
*Link:* [http://www.lejos.org/](http://www.lejos.org/)
*Versione:* NXJ 0.9.1

Per la realizazione del progetto usufruiremo dei nostri computer portatili:
- Apple MacBookPro 15" 2018, Processore Intel&reg; Core I7, RAM 16GB, Disk 1TB SSD, Mac OS X 10.14.1
- HP ENVY Notebook, Intel&reg; CORE&tm; I7, RAM 16GB, Windows 10 Home 64bit

## Progettazione

Questo capitolo descrive esaustivamente come deve essere realizzato il
prodotto fin nei suoi dettagli. Una buona progettazione permette
all’esecutore di evitare fraintendimenti e imprecisioni
nell’implementazione del prodotto.

### Design dell’architettura del sistema

Descrive:

-   La struttura del programma/sistema lo schema di rete...

-   Gli oggetti/moduli/componenti che lo compongono.

-   I flussi di informazione in ingresso ed in uscita e le
    relative elaborazioni. Può utilizzare *diagrammi di flusso dei
    dati* (DFD).

-   Eventuale sitemap

### Design dei dati e database

Descrizione delle strutture di dati utilizzate dal programma in base
agli attributi e le relazioni degli oggetti in uso.

### Schema E-R, schema logico e descrizione.

Se il diagramma E-R viene modificato, sulla doc dovrà apparire l’ultima
versione, mentre le vecchie saranno sui diari.

### Design delle interfacce

Descrizione delle interfacce interne ed esterne del sistema e
dell’interfaccia utente. La progettazione delle interfacce è basata
sulle informazioni ricavate durante la fase di analisi e realizzata
tramite mockups.

### Design procedurale

Descrive i concetti dettagliati dell’architettura/sviluppo utilizzando
ad esempio:

-   Diagrammi di flusso e Nassi.

-   Tabelle.

-   Classi e metodi.

-   Tabelle di routing

-   Diritti di accesso a condivisioni …

Questi documenti permetteranno di rappresentare i dettagli procedurali
per la realizzazione del prodotto.

## Implementazione

In questo capitolo dovrà essere mostrato come è stato realizzato il
lavoro. Questa parte può differenziarsi dalla progettazione in quanto il
risultato ottenuto non per forza può essere come era stato progettato.

Sulla base di queste informazioni il lavoro svolto dovrà essere
riproducibile.

In questa parte è richiesto l’inserimento di codice sorgente/print
screen di maschere solamente per quei passaggi particolarmente
significativi e/o critici.

Inoltre dovranno essere descritte eventuali varianti di soluzione o
scelte di prodotti con motivazione delle scelte.

Non deve apparire nessuna forma di guida d’uso di librerie o di
componenti utilizzati. Eventualmente questa va allegata.

Per eventuali dettagli si possono inserire riferimenti ai diari.

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
