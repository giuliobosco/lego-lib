# Sistema didattico per LEGO NTX con libreria e documentazione

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
    - [HelloWorld](#helloworld)
        - [Test HelloWorld](#test-helloworld)
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
    - [SingleMotor](#singlemotor)
        - [Test SingleMotor](#test-singlemotor)
    - [Navigation](#navigation)
        - [Test Navigation](#test-navigation)
    - [LineFollower](#linefollower)
        - [Test LineFollower](#test-linefollower)
    - [PropotionalLineFollower](#proportionallinefollower)
        - [Test ProportionalLineFollower](#test-proportionallinefollower)

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

### WaitAnalogSensor

Classe che serve per generalizzare le classi che aspettano un sensore analogico (microfono, tocco, ultrasuoni).

<img src="img/classes/waitanalogsensor.png" width=400>

- WAIT_TIME: Costante che definisce l'intervallo di tempo tra un controllo e un altro della fine dell'attesa. Valore: 100 (millisecondi).
- SENSOR_MIN_VALUE: Costante che definisce il minimo valore che un sensore può leggere. Valore: 0.
- SENSOR_MAX_VALUE: Costante che definisce il massimo valore che un sensore può leggere. Valore: 100.
- comparisonValue: Attributo che rappresenta il valore da comparare con quello letto dal sensore.
- bigger: Attributo che indica se il valore letto deve essere maggiore o minore di quello di confronto.
- getComparisonValue(): Metodo che serve per ottenere il valore di confronto.
- isBigger(): Metodo utile per sapere il valore dell'attributo `bigger`.
- setComparisonValue(): Metodo utile per impostare il valore di confronto controllando che sia nell'intervallo definito da `SENSOR_MIN_VALUE` e `SENSOR_MAX_VALUE`.
    ```
    public void setComparisonValue(byte comparisonValue) {
        if (comparisonValue >= SENSOR_MIN_VALUE && comparisonValue <= SENSOR_MAX_VALUE) {
            this.comparisonValue = comparisonValue;
        }
    }
    ```
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
    ```
    public void waitLight() {
        boolean finished = false;
        while (!finished) {
            try {
                if (this.isBigger()) {
                    finished = this.getLightSensor().getLightValue() > this.getComparisonValue();
                } else {
                    finished = this.getLightSensor().getLightValue() < this.getComparisonValue();
                }
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }
    ```

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
    ```
    public void waitMotor() {
        boolean finished = false;
        while (!finished) {
            try {
                int earlyRotations = this.getSingleMotor().getMotor().getTachoCount();
                while (earlyRotations + this.getComparisonValue() != earlyRotations) {
                    Thread.sleep(1000);
                }
                finished = true;
            } catch (InterruptedException ignored) {
            }
        }
    }
    ```

#### Test WaitMotor

### WaitNxtButton

Classe utile per aspettare la pressione di uno dei pulsanti presenti sul brick NXT. L'implementazione è molto semplice poiché esiste la classe `Button` che contiene il necessario per far funzionare correttamente l'attesa.

- button(): Metodo che aspetta la pressione del pulsante passato.
    ```
    public static void button(Button button) {
        // waiting for pressing the button.
        button.waitForPress();
    }
    ```
- enterButton(): Metodo che aspetta la pressione del pulsante centrale.
    ```
    public static void enterButton() {
        button(Button.ENTER);
    }
    ```
- rightButton(): Metodo che aspetta la pressione del pulsante destro".
- leftButton(): Metodo che aspetta la pressione del pulsante sinistro.
- escapeButton(): Metodo che aspetta la pressione del pulsante in basso.

#### Test WaitNxtButton

### WaitSoundSensor

Classe figlia di `WaitAnalogSensor` che aspetta che il microfono percepisca un certo valore.

- soundSensor: Attributo che rappresenta il sensore di suono (microfono).
- getSoundSensor(): Metodo che serve per ottenere il microfono.
- setSoundSensor(): Metodo utile per impostare il microfono.
- WaitSoundSensor(): Metodo costruttore, istanzia un nuovo `WaitSoundSensor` impostando il valore di confronto, se il valore letto deve essere maggiore di quello di confronto e il sensore o la porta del brick in cui è inserito il sensore.
- waitSound(): È il metodo principale che termina l'attesa in base al valore di confronto.
    ```
    public void waitSound() {
        boolean finished = false;
        while (!finished) {
            try {
                if (this.isBigger()) {
                    finished = this.getSoundSensor().readValue() > this.getComparisonValue();
                } else {
                    finished = this.getSoundSensor().readValue() < this.getComparisonValue();
                }
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }
    ```

#### Test WaitSoundSensor

### WaitTime

Classe utile per aspettare semplicemente del tempo.

- waitTime: Attributo che rappresenta il tempo da aspettare (in millisecondi).
- startTime: Attributo che rappresenta il tempo iniziale trascorso.
- getWaitTime(): Metodo che serve per ottenere il tempo da aspettare.
- getStartTime(): Metodo che serve per ottenere il tempo iniziale.
- setWaitTime(): Metodo utile per impostare il tempo da aspettare.
- setStartTime(): Metodo utile per impostare il tempo iniziale.
- WaitTime(): Metodo costruttore, crea una nuova attesa definendo il tempo da aspettare.
- waitTime(): È il metodo principale che aspetta il tempo definito.
    ```
    public void waitTime() {
        this.setStartTime(System.currentTimeMillis());
        boolean finished = false;
        try {
            while (!finished) {
                long sum = this.getStartTime() + this.getWaitTime();
                finished = sum >= System.currentTimeMillis();
                Thread.sleep(this.getWaitTime() / 100);
            }
        } catch (InterruptedException ignored) {
        }
    }
    ```

#### Test WaitTime

### WaitTouchSensor

Classe utile per aspettare la pressione, il rilascio o il click di un sensore di tocco.  

<img src="img/classes/waittouchsensor.png" width=400>

- WAIT_TIME: Costante che definisce l'intervallo di tempo tra un controllo e un altro della fine dell'attesa. Valore: 100 (millisecondi).
- PRESSED: Costante che definisce la pressione del sensore. Valore: 0.
- RELEASED: Costante che definisce il rilascio del sensore. Valore: 1.
- CLICKED: Costante che definisce il click (pressione e rilascio) del sensore. Valore: 2.
- touchSensor: Attributo che rappresenta il sensore di tocco.
- waitAction: Attributo che rappresenta l'azione da aspettare (premuto, rilasciato o cliccato).
- finished: Attributo interno che dice se l'attesa è finita.
- getTouchSensor(): Metodo che serve per ottenere il sensore di tocco.
- getWaitAction(): Metodo che serve per ottenere l'azione che si vuole aspettare.
- setTouchSensor(): Metodo utile per impostare il sensore di tocco.
- setWaitAction(): Metodo utile per impostare l'azione da aspettare.
- WaitTouchSensor(): Metodo costruttore, istanzia un nuovo `WaitTouchSensor` impostando l'azione (premuto, rilasciato, cliccato) e il sensore o la porta del brick in cui è inserito il sensore.
- isWaitAction(): Metodo utile per verificare che l'azione da aspettare imposta sia valida.
    ```
    private boolean isWaitAction(byte waitAction) {
        if (waitAction == PRESSED || waitAction == RELEASED || waitAction == CLICKED) {
            return true;
        }
        return false;
    }
    return false;
    ```
- isPressedButton(): Metodo che dice se il sensore è premuto.
    ```
    public boolean isPressedButton() {
        return this.getTouchSensor().isPressed();
    }
    ```
- buttonPressedAction(): Metodo che aspetta la pressione del sensore.
    ```
    protected void buttonPressedAction() throws InterruptedException {
        if (!this.isPressedButton()) {
            while (!this.isPressedButton()) {
                Thread.sleep(WAIT_TIME);
            }
            this.finished = true;
        }
    }
    ```
- buttonReleasedAction(): Metodo che aspetta il rilascio del sensore.
    ```
    protected void buttonReleasedAction() throws InterruptedException {
        if (this.isPressedButton()) {
            while (this.isPressedButton()) {
                Thread.sleep(WAIT_TIME);
            }
            this.finished = true;
        }
    }
    ```
- buttonClickedAction(): Metodo che aspetta il click (pressione e rilascio) del sensore.
    ```
    protected void buttonClickedAction() throws InterruptedException {
        this.buttonPressedAction();
        this.buttonReleasedAction();
    }
    ```
- waitTouch(): È il metodo principale che termina l'attesa in base all'azione impostata.
    ```
    public void waitTouch() {
        while (!this.finished) {
            try {
                if (this.getWaitAction() == PRESSED) {
                    this.buttonPressedAction();
                } else if (this.getWaitAction() == RELEASED) {
                    this.buttonReleasedAction();
                } else if (this.getWaitAction() == CLICKED) {
                    this.buttonClickedAction();
                }
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }
    ```

#### Test WaitTouchSensor

### WaitUltrasonicSensor

Classe figlia di `WaitAnalogSensor` che aspetta che il sensore a ultrasuoni percepisca un certo valore.

- ultrasonicSensor: Attributo che rappresenta il sensore a ultrasuoni.
- getUltrasonicSensor(): Metodo che serve per ottenere il sensore.
- setUltrasonicSensor(): Metodo utile per impostare il sensore.
- WaitUltrasonicSensor(): Metodo costruttore, istanzia un nuovo `WaitUltrasonicSensor` impostando il valore di confronto, se il valore letto deve essere maggiore di quello di confronto e il sensore o la porta del brick in cui è inserito il sensore.
- waitUltrasonic(): È il metodo principale che termina l'attesa in base al valore di confronto.
    ```
    public void waitUltrasonic() {
        boolean finished = false;
        while (!finished) {
            try {
                if (this.isBigger()) {
                    finished = this.getUltrasonicSensor().getDistance() > this.getComparisonValue();
                } else {
                    finished = this.getUltrasonicSensor().getDistance() < this.getComparisonValue();
                }
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ignored) {
            }
        }
    }
    ```

#### Test WaitUltrasonicSensor

### SingleMotor

Classe utile per gestire un motore grande LEGO.

- PORT_A: Costante che definisce la porta `A` del brick. Valore: 'A'.
- PORT_B: Costante che definisce la porta `B` del brick. Valore: 'B'.
- PORT_C: Costante che definisce la porta `C` del brick. Valore: 'C'.
- MIN_POWER: Costante che definisce la potenza minima del motore. Valore: 0.
- MAX_POWER: Costante che definisce la potenza massima del motore. Valore: 100.
- motorPort: Attributo che rappresenta la porta dove è collegato il motore.
- motor: Attributo che rappresenta il motore.
- power: Attributo che rappresenta la potenza del motore.
- getMotorPort(): Metodo che serve per ottenere la porta in cui è collegato il motore.
- getMotor(): Metodo che serve per ottenere il motore.
- getPower(): Metodo che serve per ottenere la potenza del motore.
- setMotorPort(): Metodo utile per impostare la porta in cui è collegato il motore.
    ```
    private void setMotorPort(char motorPort) {
        if (this.isMotorPort(motorPort)) {
            this.motorPort = motorPort;
            this.setMotor(this.motorPort);
        }
    }
    ```
- setMotor(): Metodo utile per impostare il motore, se non si passa il motore si può usare la porta in cui esso è collegato.
    ```
    private void setMotor(NXTRegulatedMotor motor) {
        this.motor = motor;
    }

    private void setMotor(char motorPort) {
        this.motorPort = motorPort;
        if (motorPort == PORT_A) {
            this.setMotor(Motor.A);
        } else if (motorPort == PORT_B) {
            this.setMotor(Motor.B);
        } else if (motorPort == PORT_C) {
            this.setMotor(Motor.C);
        }
    }
    ```
- setPower(): Metodo utile per impostare la potenza del motore.
    ```
    public void setPower(byte power) {
        if (power > MAX_POWER) {
            power = MAX_POWER;
        } else if (power < MIN_POWER) {
            power = MIN_POWER;
        }
        this.power = power;
        this.getMotor().setSpeed(this.getPower());
    }
    ```
- SingleMotor(): Metodo costruttore, si crea un nuovo `SingleMotor` definendo la porta in cui è collegato.
- isMotorPort(): Metodo utile per controllare che la porta usata sia valida (`A`, `B` o `C`).
    ```
    public boolean isMotorPort(char motorPort) {
        if (motorPort == PORT_A || motorPort == PORT_B || motorPort == PORT_C) {
            return true;
        }
        return false;
    }
    ```
- increasePower(): Metodo utile per aumentare la potenza del motore.
    ```
    public void increasePower(byte value) {
        this.setPower((byte) (this.getPower() + value));
    }
    ```
- decreasePower(): Metodo utile per diminuire la potenza del motore.
    ```
    public void decreasePower(byte value) {
        this.setPower((byte) (this.getPower() - value));
    }
    ```
- start(): Metodo che serve per azionare il motore.
    ```
    public void start() {
        this.getMotor().forward();
        this.getMotor().setSpeed(this.getPower());
    }
    ```
- stop(): Metodo che ferma il motore.
    ```
    public void stop() {
        this.getMotor().stop();
    }
    ```
- rotate(): Metodo che ruota il motore dell'angolo passato.
    ```
    public void rotate(int angle) {
        this.getMotor().rotate(angle);
    }
    ```

#### Test SingleMotor

### Navigation

Classe che viene usata come base per muovere il brick tramite i due motori.

- TURNING: Costante che definisce il valore predefinito dello sterzo. Valore: 10.
- MIN_TURNING: Costante che definisce il valore minimo dello sterzo. Valore: `MIN_POWER` di `SingleMotor`.
- MAX_TURNING: Costante che definisce il valore massimo dello sterzo. Valore: `MAX_POWER` di `SingleMotor`.
- power: Attributo che rappresenta la potenza della navigazione.
- turning: Attributo che rappresenta lo sterzo della navigazione.
- leftMotor: Attributo che rappresenta il motore sinistro.
- rightMotor: Attributo che rappresenta il motore destro.
- getPower(): Metodo che serve per ottenere la potenza della navigazione.
- getTurning(): Metodo che serve per ottenere la potenza di svolta della navigazione.
- setPower(): Metodo utile per impostare la potenza della navigazione.
    ```
    public void setPower(byte power) {
        if (power > SingleMotor.MAX_POWER) {
            power = SingleMotor.MAX_POWER;
        } else if (power < SingleMotor.MIN_POWER) {
            power = SingleMotor.MIN_POWER;
        }
        this.power = power;
        this.updatePowerMotors();
    }
    ```
- setTurning(): Metodo utile per impostare la potenza di svolta della navigazione.
    ```
    public void setTurning(byte turning) {
        if (turning > MAX_TURNING) {
            turning = MAX_TURNING;
        } else if (turning < MIN_TURNING) {
            turning = MIN_TURNING;
        }
        this.turning = turning;
        this.updatePowerMotors();
    }
    ```
- Navigation(): Metodo costruttore, crea una nuova navigazione settando i motori direttamente oppure dalle porte in cui sono collegati.
- updatePowerMotors(): Metodo utile per aggiornare la potenza dei motori e di conseguenza lo sterzo.
    ```
    private void updatePowerMotors() {
        this.leftMotor.setPower(this.getPower());
        this.rightMotor.setPower(this.getPower());
        this.updateTurningMotors();
    }
    ```
- updateTurningMotors: Metodo utile per aggiornare lo sterzo dei motori.
    ```
    private void updateTurningMotors() {
        if (this.getTurning() > 0) {
            this.leftMotor.decreasePower(this.getTurning());
            this.rightMotor.increasePower(this.getTurning());
        } else {
            this.leftMotor.increasePower((byte) - this.getTurning());
            this.rightMotor.decreasePower((byte) - this.getTurning());
        }
    }
    ```
- increasePower(): Metodo che serve per aumentare la potenza della navigazione.
    ```
    public void increasePower(byte value) {
        this.setPower((byte) (this.getPower() + value));
    }
    ```
- decreasePower(): Metodo che serve per diminuire la potenza della navigazione.
    ```
    public void decreasePower(byte value) {
        this.setPower((byte) (this.getPower() - value));
    }
    ```
- increaseTurning(): Metodo che serve per aumentare la potenza di svolta della navigazione.
    ```
    public void increaseTurning(byte value) {
        this.setTurning((byte) (this.getTurning() + value));
    }
    ```
- decreaseTurning(): Metodo che serve per diminuire la potenza di svolta della navigazione.
    ```
    public void decreaseTurning(byte value) {
        this.setTurning((byte) (this.getTurning() - value));
    }
    ```
- left(): Metodo che permette di girare a sinistra di una certa intensità.
    ```
    public void left(byte turning) {
        this.decreaseTurning(turning);
    }
    ```
- right(): Metodo che permette di girare a destra di una certa intensità.
    ```
    public void right(byte turning) {
        this.increaseTurning(turning);
    }
    ```
- start(): Metodo che fa partire la navigazione azionando i motori.
    ```
    public void start() {
        this.leftMotor.start();
        this.rightMotor.start();
        this.setPower((byte) 0);
    }
    ```
- stop(): Metodo che ferma la navigazione arrestando i motori.
    ```
    public void stop() {
        this.leftMotor.start();
        this.rightMotor.start();
    }
    ```

#### Test Navigation

### LineFollower

Classe figlia di `Navigation` che usa due motori e un sensore di luce per seguire una linea.

- DEFAULT_LINE_ON_LEFT: Costante che definisce il valore predefinito per la posizione della linea rispetto al robot (destra o sinistra). Valore: true.
- waitLightSensor: Attributo interno che rappresenta l'attesa del sensore di luce.
- lineOnLeft: Attributo che rappresenta la posizione della linea rispetto al robot (come riferimento la sinistra).
- isLineOnLeft(): Metodo che serve per sapere la posizione della linea.
- setLineOnLeft(): Metodo utile per impostare la posizione della linea.
- LineFollower(): Metodo costruttore, crea un nuovo `LineFollower` definendo motore destro e sinistro e l'attesa del sensore di luce.
- start(): È il metodo principale che unisce la navigazione dei motori con l'attesa del sensore così da seguire la linea.
    ```
    public void start() {
        WaitLightSensor wait = this.waitLightSensor;
        // Set the comparison value of the sensor to 50 (halfway).
        wait.setComparisonValue((byte) 50);
        // The sensor value must be bigger depending on where the line is.
        wait.setBigger(this.isLineOnLeft());
        // Start of the navigation.
        super.start();
        while (true) {
            // The sensor waits the light.
            wait.waitLight();
            // Turn to the left or to the right.
            if (this.isLineOnLeft()) {
                this.right(TURNING);
            } else {
                this.left(TURNING);
            }
            // Wait for the opposite light.
            wait.setBigger(!wait.isBigger());
            wait.waitLight();
            if (this.isLineOnLeft()) {
                this.left(TURNING);
            } else {
                this.right(TURNING);
            }
            // Invert the turning again.
            wait.setBigger(!wait.isBigger());
        }
    }
    ```

#### Test LineFollower

### ProportionalLineFollower

Classe figlia di `Navigation` che usa due motori e due sensori di luce per seguire una linea in maniera proporzionale.

- DEFAULT_FOLLOW_BLACK: Costante che definisce il colore della linea da seguire (nera o bianca).
- frontLightSensor: Attributo che rappresenta Il sensore di luce frontale.
- backLightSensor: Attributo che rappresenta Il sensore di luce posteriore.
- followBlack: Attributo che rappresenta il colore della linea da seguire (come riferimento la linea nera).
- getFrontLightSensor(): Metodo che serve per ottenere il sensore di luce frontale.
- getBackLightSensor(): Metodo che serve per ottenere il sensore di luce posteriore.
- isOnBlack(): Metodo che serve per sapere il colore della linea.
- setFrontLightSensor(): Metodo utile per impostare il sensore di luce frontale.
- setBackLightSensor(): Metodo utile per impostare il sensore di luce posteriore.
- setFollowBlack(): Metodo utile per impostare il colore della linea.
- ProportionalLineFollower(): Metodo costruttore, crea un nuovo `ProportionalLineFollower` definendo motore destro e sinistro e i due sensori di luce.
- start(): È il metodo principale che unisce la navigazione dei motori con i due sensori così da seguire la linea in modo proporzionale, quindi senza avere il riferimento della posizione della linea rispetto al robot.

#### Test ProportionalLineFollower

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
