# LearnRails
Created by

Nome: MARCO
Cognome: SANFILIPPO FRITTOLA

--- DI SEGUITO E' DESCRITTA L'APP SIA COME IDEA CHE COME MOTIVAZIONE PER IL CODICE SVILUPPATO.

"5 ways to Learn Rails" è un'applicazione ideata e sviluppata come progetto finale del corso di 
Android Jam tenuto dal GDG di Torino che insegna all'utente finale 5 delle migliori feature di 
Ruby on Rails, famoso framework di programmazione web. L'idea nasce dalla volontà di voler 
avvicinare gli utenti alla programmazione Ruby on Rails in 5 semplici passi spiegati.

L'applicazione è composta da una interfaccia utente molto semplice e intuitiva, al lancio della  
stessa si nota la presenza di una immagine accompagnata da una spiegazione, in totale dunque saranno  
5 immagini caratteristiche e (5) relative spiegazioni, sotto vi è un CheckBox e poi tre Button, 2 per
la navigazione e uno per ricerca online. In genere l'utente usa l'app guardando il device dall'alto 
verso il basso, per tal motivo si è deciso di disporre le varie View con un certo ordine verticale.

La navigazione tra le varie spiegazioni è possibile grazie a questi due pulsanti ma solo quando  
l'utente ha capito il concetto spiegato: deve infatti abilitare la navigazione in avanti tramite  
lo stesso CheckBox altrimenti sarà notificato con un AlertDialog il suggerimento relativo al  
CheckBox (non visto durante il corso); è ovvio che il CheckBox funziona solo per la navigazione in  
avanti, quando l'utente vuole tornare indietro per rivedere un concetto non ha bisogno di settare  
alcun CheckBox: in tal modo si cerca di far apprendere con certezza all'utente il concetto dato e il  
CheckBox viene disabilitato alla fine della navigazione.

Se un utente decide di andare "indietro" al primo step, un messaggio di tipo Toast lo notifica con  
suggerimento di breve testo e breve durata sull'andare avanti.
Se un utente decide di andare "avanti" alla fine della navigazione, un altro messaggio di tipo Toast  
lo avvertirà della terminazione delle spiegazioni su Ruby on Rails. Il testo della spiegazione non è  
detto che stia tutto dentro la porzione di schermo assegnata alla TextView, per tal motivo è stato  
abilitato lo scrolling della TextView ma non dell'intera schermata.

L'applicazione usa infatti una sola Activity e non scorre, né cambia orientamento (che è fissato a  
verticale/portrait), non si collega ad alcun tipo di server per ottenere le informazioni mostrate ma  
fa uso di risorse locali (immagini in /drawable e testo in string.xml) che vengono dinamicamente  
cambiate tramite codice java durante la navigazione e grazie all'utilizzo di una variabile globale  
d'appoggio, che viene usata in due costrutti di tipo switch() ognuno all'interno deli metodi
associati ai Button, eseguiti quando si cliccano, solo se rispettano le condizioni specificate nei  
vari statement di tipo if/else; 
switch e if/else servono a mostrare correttamente la caratteristica da insegnare e a emulare la 
dinamicità delle informazioni mostrate nonostante vi sia una singola schermata.

Per questo motivo anche il codice risulta essere di facile lettura e le variabili sono associate ai  
loro scope con un nome che ne ricorda il funzionamento (ad esempio la variabile globale nextB è  
associata al nextButton e la funzione next(), senza parametri, è eseguita (se gli if statement lo  
consentono) quando si clicca la view che ha id: nextB). Per comodità l'applicazione è in italiano 
ma i commenti del codice interno sono stati scritti in inglese. I metodi definiti non ritornano 
valori e quasi tutti non necessitano di parametri in ingresso.

Il titolo dell'app suggerisce già quale sarà il suo scopo.
Al lancio dell'app, nel metodo onCreate, viene settato il layout della Main Activity (vedere schema  
fatto a mano su carta) e vengono inizializzate tutte le variabili globali (6 in totale); inoltre  
viene anche settata la prima caratteristica dell'insegnamento così l'utente si trova di fronte allo  
stesso insegnamento avviato. Il metodo showHint() contiene un Toast che suggerisce lo scorrimento 
manuale del testo (Toast usati in due modi differenti, con testo puro e con risorse in string.xml).
Ad ogni step successivo, essendo unica schermata con TextView avente uno Scrolling verticale, questa
viene riportata al punto iniziale (tutto verso il basso, così da leggere di nuovo dall'inizio).

La variabile globale "i" viene incrementata o decrementata solo se non ha raggiunto gli estremi del  
range fissato (1 e 5) e i vari switch NON contengono tutti i casi, in particolare si sa che cliccando  
"Previous" l'ultimo caso (5) non sarà mai raggiunto all'interno di questo metodo così come cliccando 
next il primo caso nello switch non sarà mai raggiunto e dunque per mantenere un codice leggero 
sono stati rimossi i casi inutilizzati, ciò è stato possibile grazie al debug. 
Il metodo next() contiene anche un controllo sul CheckBox che eventualmente scatena un AlertDialog. 
Si è anche deciso di far sparire il CheckBox alla fine della navigazione ma eventualmente riappare 
se l'utente torna indietro.

L'ultimo Button (moreOnLine) avvia una ricerca con argomento analogo all'insegnamento in cui viene
cliccato, infatti quando cliccato viene eseguito il metodo moreOnLine() che contiene uno switch: grazie
alla stessa variabile globale viene scelto uno dei 5 casi dello switch, adesso senza if/else, che rimandano
ad un ulteriore metodo onlineSearch() che ha come unico parametro un argomento; in questo metodo viene 
creato un intent per la ricerca web su Google.com relativamente all'argomento passato come parametro.

Quando si ritorna all'uso dell'app, l'utente troverà l'insegnamento dallo stesso punto in cui si è 
temporaneamente fermato, così da non dover iniziare da zero.
