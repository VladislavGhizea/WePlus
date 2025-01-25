<br>

# **WorkHub**

## **Premessa**

La versione presentata per ora non è completa rispetto a quelli che erano i nostri piani ma provvederemo al di fuori di queste due settimane qui a perfezionare il progetto, arrivare al nostro obiettivo che ci eravamo prefissati e ottimizzare secondo i piani futuri e le nostre possibilità.
Al momento ciò che offre WorkHub è una serie di interfacce web ancora statiche (provvedero a renderle dinamiche), per il sinin, il signup e la pagina home visibile dopo essersi registrati. In questa versione nella pagina di login il tasto accedi è legato a del codice in corso di sviluppo per poter mostrare a chi etra nel sito dei dati specifici in base al tipo di account creato, pertanto non presenta nessun collegamento ad altre sezioni. Il tasto registrati invece apre l'accesso verso la sezione di registrazione che, al termine della scelta del tipo di account permette di entrare nella sezione home che, al momento è costruita staticamente in modo da mostrare ciò che è l'idea di base. Al termine del tempo ci stavamo concentrando nel rendere il tutto dinamico e creato sulla base del DB gestito dal backend perciò eventuali errori, commenti o malfunzionamenti sono dovuti al fatto che era in corso questo processo e, per poter mostrare ciò che avevamo in mente, abbiamo dovuto tornare alla versione statica. Nel prossimi periodi ci concentreremo per rendere il tutto funzionante secondo ciò che ci eravamo prefissati in modo da finire il progetto e renderlo utilizzabile.

## **Cosa è presente nella folder**

Ci sarà una cartella denominata "WePlus" con all'interno tutte le sezioni del progetto divise appositamente.

backend--> run AppApplication
<br>
frontend--> cd frontend --> npm install --> npm run build --> npm start

(frontend--> cd frontend --> npm install --> npm run dev)

<br>

---

## **Introduzione**

WorkHub è una piattaforma che connette lavoratori e aziende, fornendo interfacce personalizzate a seconda del tipo di account. La comunicazione tra frontend e backend avviene tramite API, e i dati sono gestiti in un database centralizzato.

---

## **Struttura del Progetto**

### **Architettura Generale**

- **Tecnologie richieste**: JDK 23, Maven, Node.js

- **Frontend**: Next con TypeScript.
- **Backend**: Java con H2 database.
- **Database**: H2 Database per la gestione dei dati.
- **API**: Comunicazione RESTful tra frontend e backend.

### **Flusso dei Dati**

Il flusso dei dati segue questi passaggi:

1. L'utente interagisce con il frontend.
2. Il frontend invia richieste API al backend.
3. Il backend processa le richieste e accede al database per ottenere o salvare i dati.
4. Il backend invia la risposta al frontend per l'aggiornamento dell'interfaccia.

---

## **Tipologie di Account e Funzionalità**

### **1. Persona Fisica**

- **Descrizione**: Account per utenti che cercano lavoro.
- **Interfaccia**:
  - Visualizzazione delle aziende con posizioni aperte.
  - Funzionalità per candidarsi alle offerte di lavoro (es.: invio del CV).

### **2. Persona Giuridica**

- **Descrizione**: Account per aziende che cercano dipendenti.
- **Interfaccia**:
  - Visualizzazione dei profili dei lavoratori disponibili.
  - Funzionalità per pubblicare offerte di lavoro.

### **3. Entità Individuali (Liberi Professionisti)**

- **Descrizione**: Account per liberi professionisti.
- **Interfaccia**:
  - Visualizzazione sia delle aziende con posizioni aperte che dei lavoratori disponibili.
  - Funzionalità di networking e possibilità di collaborazioni dirette.

---

## **Database**

### **Schema del Database**

- **Persone Fisiche**:
  - `fisica_id`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `utenteGeneraleId`: FK utente generale `INT NOT NULL`
  - `nome`: Nome della persona fisica `VARCHAR(20) NOT NULL`
  - `cognome`: Cognome della persona fisica `VARCHAR(20) NOT NULL`
  - `cf`: Codice Fiscale `VARCHAR(16) NOT NULL`
  - `sesso`: Sesso della persona fisica `ENUM NOT NULL`
  - `genere`: Genere della persona fisica `ENUM NOT NULL`
  - `comnuneDiN`: Comune di nascita (sigla) `VARCHAR(2) NOT NULL`
  - `dataDiN`: Data di nascita `DATE NOT NULL`
  - `indirizzoFisicaId`: FK indirizzo di domicilio e residenza `INT NOT NULL`
- **Persone Giuridiche**:

  - `giuridica_id`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `utenteGeneraleId`: FK utente Generale `INT NOT NULL`
  - `partitaIva`: Partita Iva `VARCHAR(11) NOT NULL`
  - `tipo`: Tipo di persona giuridica `ENUM NOT NULL`
  - `ragioneSociale`: Ragione sociale `VARCHAR(25) NOT NULL`

- **Entità individuali**:

  - `entita_id`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `utenteGeneraleId`: FK utente generale `INT NOT NULL`
  - `nome`: Nome del libero professionista `VARCHAR(20) NOT NULL`
  - `cognome`: Cognome del libero professionista `VARCHAR(20) NOT NULL`
  - `cf`: Codice Fiscale `VARCHAR(16) NOT NULL`
  - `sesso`: Sesso del libero professionista `ENUM NOT NULL`
  - `genere`: Genere del libero professionista `ENUM NOT NULL`
  - `comnuneDiN`: Comune di nascita (sigla) `VARCHAR(2) NOT NULL`
  - `dataDiN`: Data di nascita `DATE NOT NULL`
  - `partitaIva`: Partita Iva `VARCHAR(11) NOT NULL`
  - `ragioneSociale`: Ragione sociale `VARCHAR(25)`
  - `indirizzoFisicaId`: FK domicilio e residenza `VARCHAR(2) NOT NULL`

- **Documenti**:

  - `documento_id`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `tipo`: tipo di documento `ENUM NOT NULL`
  - `numero`: Numero di documento `INT`
  - `scadenza`: Scadenza del documento `DATE`
  - `enteEmissivo`: Ente emissivo del documento `VARCHAR(25)`
  - `dataEmissione`: Data di emissione del documento `DATE`
  - `soggettoId`: FK soggetto che ha caricato il documento `INT NOT NULL`

- **Hobby**:

  - `hobby_id`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `descrizione`: Breve descrizione dell'hobby `VARCHAR(50) NOT NULL`

- **Indice Hobby**:

  - `hobbyId`: PK identificativo hobby `INT`
  - `utenteId`: PK identificativo soggetto `INT`

- **Indirizzi Fisica**:

  - `indirizzo_id`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `soggettoId`: FK utenteGenerale `INT UNIQUE NOT NULL`
  - `indiDomicilio`: Indirizzo di domicilio `VARCHAR(50) NOT NULL`
  - `indiResidenza`: Indirizzo di residenza `VARCHAR(50) NOT NULL`

- **Sedi**:

  - `sede_id`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `indirizzo`: Indirizzo della sede `VARCHAR(50) NOT NULL`
  - `principale`: Identificativo sede principale `BOOLEAN NOT NULL`
  - `personaGiuridicaId`: FK personaGiuridica `INT`
  - `entitaIndividualeId`: FK entitaIndividuale `INT`

- **Numeri di Telefono**:

  - `numTel_id`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `numeroUno`: Numero di telefono `INT UNIQUE NOT NULL`
  - `numeroDue`: Numero di telefono `INT UNIQUE`
  - `numeroTre`: Numero di telefono `INT UNIQUE`
  - `soggettoId`: FK utenteGenerale a cui appartiene il numero `INT NOT NULL`

- **Ambiti**:

  - `ambito_id`: PK identificativo hobby `INT AUTO_INCREMENT`
  - `nome`: PK identificativo soggetto `INT`

- **Indice Ambiti**:

  - `ambitoId`: PK identificativo ambito `INT`
  - `utenteId`: PK identificativo soggetto `INT`

- **Utenti Generali**:
  - `soggetto_id`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `username`: Nome di registrazione `VARCHAR(20) UNIQUE NOT NULL`
  - `email`: Email di registrazione `VARCHAR(30) UNIQUE NOT NULL`
  - `password`: Password di registrazione `VARCHAR(60) NOT NULL`
  - `tipo`: Tipo di account `ENUM NOT NULL`
  - `cancellato`: Stato account `BOOLEAN NOT NULL`

### **Gestione dei Dati**

I dati sono salvati nel database tramite API backend, che gestiscono operazioni CRUD (Create, Read, Update, Delete).

---

## **API**

[Swagger](http://localhost:8080/swagger-ui/index.html#/) (funziona in run)

### **Autenticazione e Sicurezza**

- Autenticazione tramite **JWT (JSON Web Token) NON ANCORA IMPLEMENTATA**.
- Validazione delle richieste e crittografia delle password.

---

## **Interfaccia Utente**

### **Design e Funzionalità**

- **Persona Fisica**: Design semplice con focus sulle offerte di lavoro.
- **Persona Giuridica**: Pannello di gestione per le offerte e i profili.
- **Liberi Professionisti**: Vista combinata di aziende e lavoratori.

---

## **Testing e Debugging**

- **JUnit5**:
  Abbiamo utilizzato JUnit5 per creare e gestire i test unitari verificando che ogni componente del sistema funzionasse correttamente in modo isolato.
- **Mockito**:
  Abbiamo utilizzato Mockito in combinazione con JUnit5 per eseguire il mocking delle dipendenze durante i test unitari.
- **Postman**:
  Nel progetto abbiamo utilizzato Postman per testare manualmente le API e verificare il corretto funzionamento delle comunicazioni tra frontend e backend.

  I primi test con JUnit5 e Mockito sono stati eseguiti prima dell'implementazione del database H2 e sono stati successivamente commentati.
  Una volta implementato il database abbiamo utilizzato Postman.

---

## **Conclusioni**

Il sito rappresenta una soluzione innovativa per connettere lavoratori e aziende, garantendo esperienze personalizzate per ogni tipo di account.

### **Piani Futuri**

- Rendere dinamico l'intero sistema (tutto costruito sulla base del tipo di account)
- Implementare una funzionalità di chat in tempo reale.
- Migliorare l’algoritmo di matching tra lavoratori e aziende.

---

## **Appendici**

- **Flusso Logico**:
  Diagramma che mostra il percorso delle richieste tra frontend, backend e database.<br>
  [Visualizza](https://www.canva.com/design/DAGcEvyNOpo/PYrwOZD7B4iOlc29qmhWNw/view)

### **Link Utili**

- [Documentazione React](https://reactjs.org/)
- [Documentazione Java](https://docs.oracle.com/en/java/)
- [Documentazione H2 Database](https://www.h2database.com/)
