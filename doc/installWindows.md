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

Innanzitutto controllare che Java sia già presente sul PC.  
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

La Java Development Kit è un ambiente di sviluppo necessario se si vuole implementare in Java, quindi qui di seguito sarà spiegato come integrarlo nel computer.  
Prima di tutto scaricare l'installer della versione a 32 bit per Windows ([https://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-windows-i586.exe](https://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-windows-i586.exe)). Successivamente aprire il file appena scaricato e seguire la procedura.

### Variabili d'ambiente

Prima di poter utilizzare Java bisogna impostare le sue `variabili d'ambiente`. Quindi andare nella cartella dove si ha installato Java (probabilmente `C:\Program Files (x86)\Java\<versione di Java>\bin`), copiare i percorsi delle due cartelle fino a `bin` e aprire il `Pannello di controllo`, recarsi nella sezione `Sistema`, poi su `Variabili d'ambiente` che si trovano sotto le impostazioni `Avanzate` e infine aggiungere il percorso nella variabile di sistema `Path`.

<img src="img/variables.png" alt="Variables" width="50%"/><img src="img/path.png" alt="Path" width="50%"/>

Dopodiché eseguire i test aprendo la finestra come spiegato all'inizio del capitolo ([Java Runtime Environment](#java-runtime-environment)):
```
java -version
javac -version
```
il primo comando dovrebbe far uscire una scritta come quella vista precedentemente, mentre il secondo farà apparire scritta come questa:
```
javac 1.8.0_161
```
Arrivati a questo punto, sigifica che la macchina è pronta per sviluppare in Java, ma per utilizzare un robot NXT, bisognerà procedere con la guida.

## Driver USB

Per fare in modo che il computer individui il dispositivo LEGO&reg;, è necessario disporre di un driver USB. Esso si scarica dal sito ufficiale Mindstorms ([https://www.lego.com/r/www/r/mindstorms/-/media/franchises/mindstorms%202014/downloads/firmware%20and%20software/nxt%20software/nxt%20fantom%20drivers%20v120.zip?l.r2=-964392510](https://www.lego.com/r/www/r/mindstorms/-/media/franchises/mindstorms%202014/downloads/firmware%20and%20software/nxt%20software/nxt%20fantom%20drivers%20v120.zip?l.r2=-964392510)) e bisognerà avviare il file `setup.exe` sotto la cartella `Windows` che si trova nella cartella compressa appena scaricata.  
Quindi verificare che il brick NXT sia riconosciuto dal vostro PC aprendo `Gestione dispositivi` dal `Pannello di controllo` e il dispositivo verrà identificato in questo modo:

<img src="img/lego-device.png" alt="LEGO device" width="67%"/>

## leJOS

Dopo aver svolto i passaggi nei capitoli precedenti, sarà possibile finalmente installare leJOS NXJ, cioè l'ambiente per sviluppare programmi per robot NXT.

### Installazione

Procedere scaricando l'applicativo dell'ultima versione (0.9.1) dal sito ([https://sourceforge.net/projects/nxt.lejos.p/files/latest/download](https://sourceforge.net/projects/nxt.lejos.p/files/latest/download)). Quindi avviare il documento appena scaricato e eseguire la procedura guidata dell'installer.

### Configurazione

Assicurarsi che il brick sia acceso collegato correttamente via USB, successivamente finire la configurazione avviando la finestra finale dove è attivata l'opzione `Launch NXJ Flash utility`. L'applicazione dovrebbe identificare il brick, quindi cliccare `Start program` e procedere con l'attivazione del firmware.  
Ora la configurazione è giunta al termine e sul NXT dovrebbe apparire la schermata di leJOS.

## Utilizzo

In questo capitolo viene spiegato come iniziare a programmare con leJOS NXJ tramite un classico `HelloWorld`. È solamente necessario disporre di un editore di testo per scrivere il codice.

### HelloWorld

Iniziare creando il file `HelloWorld.java` e scrivendo la classe `HelloWorld` tramite il pacchetto predefinito di Java.
```
public class HelloWorld {

}
```
Proseguire implementando il metodo `main` (che viene di solito usato come il metodo che genera un output).
```
public class HelloWorld {
    public static void main (String[] args) {

    }
}
```
Ora scrivere la classica funzione che genera un output sotto forma di testo nello schermo LCD del brick.
```
public class HelloWorld {
    public static void main (String[] args) {
        System.out.println("Hello World");
    }
}
```
Se si avvia il programma in questo modo, verrà mostrata la scritta "HelloWorld" e si tornerà immediatamente nella schermata principale. Per limitare questo comportamento, si può inserire l'opzione che aspetta la pressione di un pulsante. Per fare ciò basta importare la libreria `Button` e inserire un semplice metodo.
```
import lejos.nxt.Button;

public class HelloWorld {
    public static void main (String[] args) {
        System.out.println("Hello World");
        Button.waitForAnyPress();
    }
}
```
Adesso il codice è pronto per essere compilato nel NXT e avviato.

### Compilazione e avvio

Per verificare il funzionamento del codice appena scritto, bisogna aprire un'istanza di `Windows PowerShell` nella cartella dove si trova il file `HelloWorld.java`, cliccando sul menu `File` in alto a sinistra e scegliendo `Apri Windows PowerShell`.  
Si dovrebbe aprire una schermata blu, in cui occorre scrivere i seguenti comandi uno dopo l'altro:
```
nxjc HelloWorld.java
```
Compilazione del file.
```
nxjlink -o HelloWorld.nxj HelloWorld  
```
Caricamento della classe in un file compatibile con NXT.
```
nxjupload -r HelloWorld.nxj
```
Caricamento del file nel brick.
```
nxj -r -o HelloWorld.nxj HelloWorld
```
Avviamento del programma.