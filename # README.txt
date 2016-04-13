Created by

Nome: MARCO
Cognome: SANFILIPPO FRITTOLA


***

In questo documento vengono fornite le istruzioni per il Setup del progetto android "5 ways to Learn Rails" e per lanciare l'applicazione creata.

Si da per assodato che siano già installati l'IDE (Android Studio) con i vari SDK (almeno dal 15 in su) e almeno un emulatore virtuale compatibile per testare l'applicazione o i driver necessari all'ambiente per riconoscere un device Android reale. Diversamente, è possibile farlo tramite developer.android.com altrimenti non sarà possibile avviare il progetto. E' necessario disporre di un cavo USB compatibile per collegare il device reale al PC ed aver abilitato il debug USB dalla voce OPZIONI SVILUPPATORE (questa voce non appare se non prima si attiva tramite le impostazioni, dopo aver cliccato 7 volte consecutive su NUMERO BUILD dalla voce INFO TELEFONO);

Il progetto si trova nella cartella LearnRails, posizionarla con tutto il suo contenuto in una posizione a piacere 
(nel mio caso, C:\Users\Marco\Documents\AndroidStudioProject) purchè venga ricordata negli step successivi.
Avviare Android Studio e chiudere eventuali progetti aperti, selezionare poi la voce "Open an Existing Android Studio Project"
Si aprirà una finestra di navigazione per le cartelle, navigare fino alla cartella in cui si trova in progetto fin quando non si trova la cartella "LearnRails" (con icona verde di Android Studio); selezionarla e attenderne l'apertura e il caricamento da parte di Android Studio; 
E' possibile che a causa delle diverse versioni di Android Studio vi siano incompatibilità di "Gradle" che sono segnalate ma automaticamente risolvibili dall'IDE stesso se si autorizza a farlo quando richiesto. una volta completato, a sinistra vi è il menu di navigazione;

Selezionare "Project" sulla barra laterale, "Android" dal menu a tendina nella sezione appena comparsa e poi navigare tra le varie cartelle del codice per visionarlo, in particolare i percorsi sono:
app -> manifest, contiene AndroidManifest.xml per l'app;
app -> java -> com.marcosanfilippo.learnrails, contiene tutto il codice java necessario al funzionamento dell'app;
app -> res, contiene le risorse del progetto: drawable per le immagini, layout per i layout files delle varie activities (una in tal caso), mipmap per i file icona dell'app dimensionati opportunamente, values contiene diversi file tra cui colors.xml per la definizione dei colori usati nell'app, strings.xml per le stringhe e styles.xml definisce per AppTheme (impostato nel manifest) quali colori sono utilizzati per la ActionBar e altro...

Per visionare il codice fare riferimento al file MainActivity.java sotto java/com.marcosanfilippo.learnrails e analogamente per il layout fare riferimento al file activity_main.xml sotto la cartella res/layout;

Il MainActivity è commentato e spiegato in "SOLUTION DESIGN", per il layout vedere l'immagine AppDesign.

Per il BUILD dell'app si consiglia di fare un Clean Project dalla voce "Build" del menu in alto e poi seleionare Make Project (o diversamente, fare Rebuild Project) sempre sotto la stessa voce di menu.

Per lanciare l'app bisogna cliccare sul comando play (colore verde) oppure con MAIUSC+F10.
Vi sarà richiesto di selezionare un emulatore virtuale o un device reale che sia abilitato al debug.
Se non è presente nessuno dei due tipi, si può avviare un emulatore virtuale e l'app sarà mandata in run dopo il suo caricamento. Se si vuole testare l'app in diversi device si SCONSIGLIA di selezionare la voce "Usa questo device per i futuri lanci" così sarà chiesto ad ogni lancio cosa scegliere tra i dispositivi attivi e compatibili.
Per il debug cliccare l'icona accanto a destra a quella di RUN oppure MAIUSC+F9.
