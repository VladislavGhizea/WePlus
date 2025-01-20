
swagger, docusaurus

# **Documentazione del Sito Web**

## **Introduzione**
Il sito web è una piattaforma che connette lavoratori e aziende, fornendo interfacce personalizzate a seconda del tipo di account. La comunicazione tra frontend e backend avviene tramite API, e i dati sono gestiti in un database centralizzato.

---

## **Struttura del Progetto**

### **Architettura Generale**
- **Frontend**: React con TypeScript.
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
- **Tabella Utenti**:
  - `id`: Identificativo univoco.
  - `nome`: Nome dell'utente.
  - `email`: Email dell'utente.
  - `tipo_account`: Persona fisica, persona giuridica o entità individuale.
  
- **Tabella Offerte di Lavoro**:
  - `id`: Identificativo univoco.
  - `titolo`: Titolo dell'offerta.
  - `descrizione`: Descrizione dettagliata.
  - `azienda_id`: Riferimento all'azienda che ha pubblicato l'offerta.

### **Gestione dei Dati**
I dati sono salvati nel database tramite API backend, che gestiscono operazioni CRUD (Create, Read, Update, Delete).

---

## **API**

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

### **Autenticazione e Sicurezza**
- Autenticazione tramite **JWT (JSON Web Token)**.
- Validazione delle richieste e crittografia delle password.

---

## **Interfaccia Utente**

### **Design e Funzionalità**
- **Persona Fisica**: Design semplice con focus sulle offerte di lavoro.
- **Persona Giuridica**: Pannello di gestione per le offerte e i profili.
- **Liberi Professionisti**: Vista combinata di aziende e lavoratori.

### **Esempi di Schermate**
Inserire screenshot o mockup per rappresentare le diverse interfacce utente.

---

## **Testing e Debugging**
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
### **Diagrammi**
- **ER Diagram del Database**:
  - Rappresentazione grafica delle tabelle e delle relazioni.
  
- **Flusso delle API**:
  - Diagramma che mostra il percorso delle richieste tra frontend, backend e database.

### **Link Utili**
- Documentazione React: [https://reactjs.org/](https://reactjs.org/)
- Documentazione Java: [https://docs.oracle.com/en/java/](https://docs.oracle.com/en/java/)
- Documentazione H2 Database: [https://www.h2database.com/](https://www.h2database.com/)


