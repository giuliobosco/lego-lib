# Libreria LEGO | Diario di lavoro - 08.02.2019
##### Gabriele Alessi, Giulio Bosco
### Canobbio, 08.02.2019

## Lavori svolti
Oggi è il giorno di consegna del progetto, quindi abbiamo concluso la documentazione, eseguito gli ultimi test e rivisto le ultime cose.  
Questi sono due esempi di test case:

|Test Case      | TC-001                               |
|---------------|--------------------------------------|
|**Nome**       |Verificare il funzionamento di leJOS su NXT e produrre una guida|
|**Riferimento**|REQ-01                               |
|**Descrizione**|Installare il firmware sul brick NXT che si vuole utilizzare e caricarci un programma Java verificando il funzionamento e fare una guida della procedura|
|**Prerequisiti**|Avere Java installato sulla macchina e scrivere un semplice programma di test |
|**Procedura**     | <ul><li>Installare il driver USB per collegare il NXT </li><li>Installare e configurare leJOS</li><li>Scrivere un programma di test, ad esempio <code>HelloWorld</code></li><li>Produrre una guida di tutto il procedimento</li></ul> |
|**Risultati attesi** |Il computer identifica il brick NXT e si riesce a caricare ed eseguire un programma Java e la guida è stata fatta (<code>usareLegoLib</code>)|

|Test Case      | TC-002                               |
|---------------|--------------------------------------|
|**Nome**       |Controllare i sensori: TouchSensor |
|**Riferimento**|REQ-02                               |
|**Descrizione**|Controllare che il sensore di tocco funzioni correttamente con leJOS |
|**Prerequisiti**|Aver installato il firmware leJOS sul brick NXT |
|**Procedura**     | <ul><li>Collegare il sensore di touch alla porta 1 del brick NXT</li><li>Caricare sul brick il programma <code>TestTouchSensor</code></li><li>Eseguire il programma</li></ul>|
|**Risultati attesi** |Quando il touch sensor &egrave; premuto dovrebbe ritornare <b>true</b>, mentre quando non lo &egrave; dovrebbe ritornare <b>false</b>. |

Inoltre è stato modificato il requisito in modo che risponda a ciò che abbiamo sviluppato:

|ID  |REQ-03                                          |
|----|------------------------------------------------|
|**Nome**    |Sviluppo blocchetti arancioni|
|**Priorità**|1                     |
|**Versione**|3.0                   |
|**Note**    |Creare delle classi che simulino i blocchetti arancioni dell'ambiente di sviluppo Mindstorms.|
| *Sub-req 1* |Sensore di luce |
| *Sub-req 2* |Sensore di tocco |
| *Sub-req 3* |Sensore a ultrasuoni (distanza) |
| *Sub-req 4* |Microfono |
| *Sub-req 5* |Pulsanti del brick |
| *Sub-req 6* |Motore |
| *Sub-req 7* |Tempo |

|ID  |REQ-04                                          |
|----|------------------------------------------------|
|**Nome**    |Sviluppo blocchetti verdi|
|**Priorità**|1                     |
|**Versione**|3.0                   |
|**Note**    |Ogni attuatore deve avere dei metodi per controllarlo.|
| *Sub-req 1* |Motore |
| *Sub-req 2* |Navigazione a due motori |

Abbiamo anche fatto i test case:

| Test Case | Risultato  |
| --------- | ---------- |
| TC-001    | <p style="color:lime;">Il brick &egrave; stato configurato correttamente e il programma viene eseguito producendo l'output voluto (Il test &egrave; spiegato in questa documentazione). Inoltre &egrave; anche presente la guida dell'installazione e dell'utilizzo del prodotto (usareLegoLib).</p> |

Quindi alla fine della lezione abbiamo consegnato la documentazione del progetto insieme a tutti gli allegati necessari.

|Orario        |Lavoro svolto					|
|--------------|------------------------------	|
|13:15 - 16:30 |Conclusione e consegna progetto|

##  Problemi riscontrati e soluzioni adottate
Nessun problema riscontrato.
##  Punto della situazione rispetto alla pianificazione
Progetto consegnato in tempo.