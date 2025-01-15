DROP TABLE PersoneFisiche;
DROP TABLE PersoneGiuridiche;
DROP TABLE EntitaIndividuali;
DROP TABLE Documenti;
DROP TABLE Hobby;
DROP TABLE IndiceHobby;
DROP TABLE Indirizzi_Fisica;
DROP TABLE Sedi;
DROP TABLE NumeriTelefono;
DROP TABLE Ambiti;
DROP TABLE IndiceAmbiti;
DROP TABLE UtentiGenerali;

CREATE TABLE PersoneFisiche (
  id_fisica INT PRIMARY KEY,
  generale_id INT NOT NULL,
  nome VARCHAR(20) NOT NULL,
  cognome VARCHAR(20) NOT NULL,
  cf VARCHAR(16) NOT NULL,
  sesso ENUM() NOT NULL,
  genere VARCHAR(255) NOT NULL,
  comunediN VARCHAR(255) NOT NULL,
  datadiN VARCHAR(255) NOT NULL,
  indirizzo_id INT,
  FOREIGN KEY (generale_id) REFERENCES another_table(id),
  FOREIGN KEY (indirizzo_id) REFERENCES another_table(id)
);

CREATE TABLE Persone_giuridiche (
  id_giuridica INT PRIMARY KEY,
  generale_id INT,
  partitaIva VARCHAR(255) NOT NULL,
  tipo VARCHAR(255) NOT NULL,
  ragione_sociale VARCHAR(255) NOT NULL,
  sede_id INT,
  FOREIGN KEY (generale_id) REFERENCES another_table(id),
  FOREIGN KEY (sede_id) REFERENCES another_table(id)
);

CREATE TABLE Documenti (
  id_documento INT PRIMARY KEY,
  tipo VARCHAR(255) NOT NULL,
  numero VARCHAR(255) NOT NULL,
  scadenza INT,
  FOREIGN KEY (scadenza) REFERENCES another_table(id)
);

CREATE TABLE Hobby (
  id_hobby INT PRIMARY KEY
);

CREATE TABLE IndiceHobby (
  id_hobby INT,
  id_soggetto INT,
  PRIMARY KEY (id_hobby, id_soggetto)
);

CREATE TABLE Indirizzi_Fisica (
  id_indirizzo INT PRIMARY KEY,
  indiDomicilio VARCHAR(255) NOT NULL,
  indiResidenza VARCHAR(255) NOT NULL
);

CREATE TABLE Utenti_Generali (
  id_generale INT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255),
  password VARCHAR(255) NOT NULL,
  tipo VARCHAR(255) NOT NULL,
  cancellato VARCHAR(255) NOT NULL
);