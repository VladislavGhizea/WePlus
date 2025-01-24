<br>

# **TODO swagger, docusaurus, normalizzare API, normalizzare e controllare campi frontend, LISTA ENUM, Chat MongoDB, Foto, Recensioni, AUTENTICAZIONE E SICUREZZA, Documenti, Controllo e modifica documentazione, per riferimenti a utente generale passare l'id generale assegnato, MODULO DI PSW DIMENTICATA, CONTROLLO CAMPI E NORMALIZZAZIONE frontend, SCROLLBAR LATERALE filtri, Cambio tipo entità giuridica**

backend--> run AppApplication
frontend--> cd frontend --> npm install --> npm run dev

<br><br><br>

---

# **WorkHub**

## **Introduzione**

Il sito web è una piattaforma che connette lavoratori e aziende, fornendo interfacce personalizzate a seconda del tipo di account. La comunicazione tra frontend e backend avviene tramite API, e i dati sono gestiti in un database centralizzato.

---

## **Struttura del Progetto**

### **Architettura Generale**

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
  - `id_fisica`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `generale_id`: FK utente generale `INT NOT NULL`
  - `nome`: Nome della persona fisica `VARCHAR(20) NOT NULL`
  - `cognome`: Cognome della persona fisica `VARCHAR(20) NOT NULL`
  - `cf`: Codice Fiscale `VARCHAR(16) NOT NULL`
  - `sesso`: Sesso della persona fisica `ENUM NOT NULL`
  - `genere`: Genere della persona fisica `ENUM NOT NULL`
  - `comnuneDiN`: Comune di nascita (sigla) `VARCHAR(2) NOT NULL`
  - `dataDiN`: Data di nascita `DATE NOT NULL`
  - `indirizzo_id`: FK indirizzo di domicilio e residenza `VARCHAR(2) NOT NULL`
- **Persone Giuridiche**:

  - `id_giuridica`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `generale_id`: FK utente Generale `INT NOT NULL`
  - `partitaIva`: Partita Iva `VARCHAR(11) NOT NULL`
  - `tipo`: Tipo di persona giuridica `ENUM NOT NULL`
  - `ragione_sociale`: Ragione sociale `VARCHAR(25) NOT NULL`
  - `sede_id`: FK indirizzo della sede `INT NOT NULL`

- **Entità individuali**:

  - `id_entita`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `generale_id`: FK utente generale `INT NOT NULL`
  - `nome`: Nome del libero professionista `VARCHAR(20) NOT NULL`
  - `cognome`: Cognome del libero professionista `VARCHAR(20) NOT NULL`
  - `cf`: Codice Fiscale `VARCHAR(16) NOT NULL`
  - `sesso`: Sesso del libero professionista `ENUM NOT NULL`
  - `genere`: Genere del libero professionista `ENUM NOT NULL`
  - `comnuneDiN`: Comune di nascita (sigla) `VARCHAR(2) NOT NULL`
  - `dataDiN`: Data di nascita `DATE NOT NULL`
  - `partitaIva`: Partita Iva `VARCHAR(11) NOT NULL`
  - `ragione_sociale`: Ragione sociale `VARCHAR(25)`
  - `indirizzoFisica_id`: FK domicilio e residenza `VARCHAR(2) NOT NULL`
  - `indirizzoSede_id`: FK indirizzo della sede `INT NOT NULL`

- **Documenti**:

  - `id_documento`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `tipo`: tipo di documento `ENUM NOT NULL`
  - `numero`: Numero di documento `INT`
  - `scadenza`: Scadenza del documento `DATE`
  - `enteEmissivo`: Ente emissivo del documento `VARCHAR(25)`
  - `dataEmissione`: Data di emissione del documento `DATE`
  - `soggetto_id`: FK soggetto che ha caricato il documento `INT NOT NULL`

- **Hobby**:

  - `id_hobby`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `descrizione`: Breve descrizione dell'hobby `VARCHAR(50)`

- **Indice Hobby**:

  - `id_hobby`: PK identificativo hobby `INT`
  - `id_soggetto`: PK identificativo soggetto `INT`

- **Indirizzi Fisica**:

  - `id_indirizzo`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `indiDomicilio`: Indirizzo di domicilio `VARCHAR(50) NOT NULL`
  - `indiResidenza`: Indirizzo di residenza `VARCHAR(50) NOT NULL`

- **Sedi**:

  - `id_sede`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `indirizzo`: Indirizzo della sede `VARCHAR(50) NOT NULL`
  - `principale`: Identificativo sede principale `BOOLEAN NOT NULL`

- **Numeri di Telefono**:

  - `id_numTel`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `numero`: Numero di telefono `INT NOT NULL`
  - `soggetto_id`: FK soggetto a cui appartiene il numero `INT NOT NULL`

- **Ambiti**:

  - `id_ambito`: PK identificativo hobby `INT AUTO_INCREMENT`
  - `nome`: PK identificativo soggetto `INT`

- **Indice Ambiti**:

  - `id_ambito`: PK identificativo ambito `INT`
  - `id_soggetto`: PK identificativo soggetto `INT`

- **Utenti Generali**:
  - `id_generale`: PK identificativo univoco `INT AUTO_INCREMENT`
  - `username`: Nome di registrazione `VARCHAR(20) NOT NULL`
  - `email`: Email di registrazione `VARCHAR(30) UNIQUE`
  - `password`: Password di registrazione `VARCHAR(20) NOT NULL`
  - `tipo`: Tipo di account `ENUM NOT NULL`
  - `cancellato`: Stato account `BOOLEAN NOT NULL`

### **Gestione dei Dati**

I dati sono salvati nel database tramite API backend, che gestiscono operazioni CRUD (Create, Read, Update, Delete).

---

## **API** TODO

http://localhost:8080/swagger-ui/index.html#/

### **Descrizione delle API Principali**

- **Endpoint**: `/api/jobs`

  - **Metodo**: `GET`
  - **Descrizione**: Recupera le offerte di lavoro disponibili.

- **Endpoint**: `/api/users`

  - **Metodo**: `POST`
  - **Descrizione**: Registra un nuovo utente.

- **Endpoint**: `/api/applications`
  - **Metodo**: `POST`
  - **Descrizione**: Permette a un utente di candidarsi per un'offerta di lavoro.

### **Autenticazione e Sicurezza** TODO

- Autenticazione tramite **JWT (JSON Web Token)**.
- Validazione delle richieste e crittografia delle password.

---

## **Interfaccia Utente**

### **Design e Funzionalità**

- **Persona Fisica**: Design semplice con focus sulle offerte di lavoro.
- **Persona Giuridica**: Pannello di gestione per le offerte e i profili.
- **Liberi Professionisti**: Vista combinata di aziende e lavoratori.

---

## **Testing e Debugging** TODO

- **Testing**:
  - Unit test per API e logica backend.
  - Test di integrazione per il flusso dati completo.
- **Strumenti**:
  - Postman per il testing delle API.
  - Debugger integrati in Java e browser per il frontend.

---

## **Conclusioni**

Il sito rappresenta una soluzione innovativa per connettere lavoratori e aziende, garantendo esperienze personalizzate per ogni tipo di account.

### **Piani Futuri**

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
