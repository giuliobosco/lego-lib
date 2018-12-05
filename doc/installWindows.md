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

### Java Runtime Environment

Innanzitutto controllare che Java sia già presente sul pc.  
Aprire una finestra del promt dei comandi: premere il tasto di windows <img src="img/win-key.png" alt="Windows Key" width="20"/> (sulla tastiera) e contemporaneamente il tasto `R` il quale farà comparire una finestra in basso a sinistra.  
Nel campo di testo della seguente digitare `cmd` e premere su invio. Comparirà una finestra nera, sulla quale digitare il seguente comando e premere invio:

```
java -version
```

Dopo aver premuto invio se compare una scritta come la seguente, passare direttamente al passo [Java - Java Development Kit](Java - Java Development Kit), altrimenti proseguire con la guida:

```
java version "1.8.0_171"
Java(TM) SE Runtime Environment (build 1.8.0_171-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.171-b11, mixed mode)
```

Per installare Java, bisogna scaricare il file di installazione, dal sito ufficiale della Oracle&reg;: [https://www.java.com/en/download/](https://www.java.com/en/download/), dopo aver scaricato il file d'installazione, aprirlo e seguire la procedura guidata.

Prima di poter utilizzare Java bisogna settare le sue Variabili d'ambiente, quindi andare nella cartella dove si ha installato Java, probabilmente `C:\Program Files\Java\Java-version\bin`, copiare il percorso e aprire il `Pannello di controllo`, recarsi nella sezione `sistema`, poi su `variabili d'ambiente` ed infine aggiungere quella copiata.

Dopo di che rieseguire il test.

### Java Development Kit

## Driver USB

## leJOS

### Installazione

### Configurazione

## Utilizzo

### HelloWorld