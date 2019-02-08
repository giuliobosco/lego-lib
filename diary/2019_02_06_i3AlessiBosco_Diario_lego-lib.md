# Libreria LEGO | Diario di lavoro - 06.02.2019
##### Gabriele Alessi, Giulio Bosco
### Canobbio, 06.02.2019

## Lavori svolti
Durante questa giornata ci siamo concentrati sulla documentazione, la guida e sui test modulari.  
Il capitolo di implementazione è concluso e ora mancano principalmente i test. Questo è un esempio di classe documentata completamente:

### WaitNxtButton

Classe utile per aspettare la pressione di uno dei pulsanti presenti sul brick NXT. L'implementazione è molto semplice poiché esiste la classe `Button` che contiene il necessario per far funzionare correttamente l'attesa.

<img src="../doc/img/classes/WaitNxtButton.png" width=400>

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
- rightButton(): Metodo che aspetta la pressione del pulsante destro.
    ```
    public static void rightButton() {
        button(Button.RIGHT);
    }
    ```
- leftButton(): Metodo che aspetta la pressione del pulsante sinistro.
    ```
    public static void leftButton() {
        button(Button.LEFT);
    }
    ```
- escapeButton(): Metodo che aspetta la pressione del pulsante in basso.
    ```
    public static void escapeButton() {
        button(Button.ESCAPE);
    }
    ```

#### Test WaitNxtButton

Per effettuare i test si usa `UseWaitNxtButton`, in cui semplicemente si usano i metodi della classe `WaitNxtButton`.
```
public static void main(String[] args) {
    // Wait for the left button.
    System.out.println("Press left button to continue");
    WaitNxtButton.leftButton();
    // Wait for the enter button.
    System.out.println("Button pressed\n\nPress enter button to continue");
    WaitNxtButton.enterButton();
    // Wait for the right button.
    System.out.println("Button pressed\n\nPress right button to continue");
    WaitNxtButton.rightButton();
    System.out.println("Button pressed\n\n");
    // Wait for the escape button.
    System.out.println("Button pressed\n\nPress escape button to continue");
    WaitNxtButton.escapeButton();
    System.out.println("Button pressed\n\n");
    // Wait for another button to end the test.
    System.out.println("Test over.");
    Button.waitForAnyPress();
}
```
I metodi funzionano correttamente perché il programma avanza al prossimo pulsante solo quando si preme quello richiesto.

Inoltre ci sarà da consegnare la presentazione, ma sarà fatta fuori dal posto perché ci servirà più tempo possibile per fare i test e tutto ciò che non possiamo fare a casa.

|Orario        |Lavoro svolto					|
|--------------|--------------------------------|
|13:15 - 16:30 |Documentazione e test|

##  Problemi riscontrati e soluzioni adottate
Ci sono stati alcuni problemi con i test ma sono stati risolti eseguendo un po' di prove.
##  Punto della situazione rispetto alla pianificazione
C'è qualcosa da recuperare con la documentazione e i test, ma si spera che per la prossima lezione sia tutto pronto se si lavora un po' in casa.
## Programma di massima per la prossima giornata di lavoro
Conclusione e consegna progetto.
