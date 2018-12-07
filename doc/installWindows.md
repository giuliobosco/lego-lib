# Installare leJOS su Windows
Questa è una guida per installare e configurare il firmware leJOS NXJ su Windows. LeJOS è basato su Java, quindi servirà un ambiente di sviluppo Java (Java Runtime Environment e Java Development Kit).

## Indice
1. [Java](#java)
    - [Java Runtime Environment](#java-runtime-environment)
    - [Java Development Kit](#java-development-kit)
    - [Variabili d'ambiente](#variabili-d'ambiente)
2. [Driver USB](#driver-usb)
3. [leJOS](#lejos)
    - [Installazione](#installazione)
    - [Configurazione](#configurazione)
5. [Utilizzo](#utilizzo)
    - [HelloWorld](#helloworld)

## Java

Java, aldilà del linguaggio di programmazione, è una tecnologia utilizzata per lo sviluppo e/o l'esecuzione di vari tipi di applicazioni.

### Java Runtime Environment

Innanzitutto controllare che Java sia già presente sul pc.  
Iniziare aprendo una finestra del `Prompt dei comandi`: premere il tasto Windows <img src="img/win-key.png" alt="Windows Key" width="20"/> che si trova sulla tastiera e contemporaneamente il tasto `R`. Quindi ciò farà aprire una piccola finestra in basso a sinistra, in cui bisognerà digitare `cmd` e premere invio. Comparirà una finestra nera, sulla quale scrivere il seguente comando:
```
java -version
```
Dopo aver premuto invio, se Java è già installato (passare al punto [Java Development Kit](#java-development-kit)), comparirà una scritta simile:
```
java version "1.8.0_191"
Java(TM) SE Runtime Environment (build 1.8.0_191-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.191-b12, mixed mode)
```
Altrimenti sarà necessario installare Java, scaricandolo dal sito ufficiale ([https://www.java.com/en/download/](https://www.java.com/en/download/)). Dopo aver scaricato il file d'installazione, aprirlo e seguire la procedura guidata.

### Java Development Kit

### Variabili d'ambiente

Prima di poter utilizzare Java bisogna settare le sue Variabili d'ambiente, quindi andare nella cartella dove si ha installato Java, probabilmente `C:\Program Files\Java\Java-version\bin`, copiare il percorso e aprire il `Pannello di controllo`, recarsi nella sezione `sistema`, poi su `variabili d'ambiente` ed infine aggiungere quella copiata.  
Dopodiché rieseguire il test spiegato all'inizio del capitolo ([Java Runtime Environment](#java-runtime-environment)).

## Driver USB

## leJOS

### Installazione

### Configurazione

## Utilizzo

### HelloWorld