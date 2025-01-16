
DROP TABLE PersoneFisiche;
DROP TABLE PersoneGiuridiche;
DROP TABLE EntitaIndividuali;
DROP TABLE Documenti;
DROP TABLE Hobby;
DROP TABLE IndiceHobby;
DROP TABLE IndirizziFisica;
DROP TABLE Sedi;
DROP TABLE NumeriTelefono;
DROP TABLE Ambiti;
DROP TABLE IndiceAmbiti;
DROP TABLE UtentiGenerali;

CREATE TABLE PersoneFisiche (
  id_fisica INT AUTO_INCREMENT PRIMARY KEY,
  generale_id INT NOT NULL,
  nome VARCHAR(20) NOT NULL,
  cognome VARCHAR(20) NOT NULL,
  cf VARCHAR(16) NOT NULL,
  sesso ENUM('MASCHIO', 'FEMMINA') NOT NULL,
  genere ENUM('MASCHILE', 'FEMMINILE', 'NON_BINARIO', 'ALTRO') NOT NULL,
  comunediN VARCHAR(2) NOT NULL,
  datadiN DATE NOT NULL,
  indirizzo_id INT NOT NULL,
  FOREIGN KEY (generale_id) REFERENCES UtentiGenerali(id_generale),
  FOREIGN KEY (indirizzo_id) REFERENCES IndirizziFisica(id_indirizzo)
);

CREATE TABLE PersoneGiuridiche (
  id_giuridica INT AUTO_INCREMENT PRIMARY KEY,
  generale_id INT NOT NULL,
  partitaIva VARCHAR(11) NOT NULL,
  tipo VARCHAR ENUM('SpA','SrL','SnC';) NOT NULL,
  ragione_sociale VARCHAR(25) NOT NULL,
  sede_id INT NOT NULL,
  FOREIGN KEY (generale_id) REFERENCES UtentiGenerali(id_generale),
  FOREIGN KEY (sede_id) REFERENCES Sedi(id_sede)
);

CREATE TABLE EntitaIndividuali (
  id_entita INT AUTO_INCREMENT PRIMARY KEY,
  generale_id INT NOT NULL,
  nome VARCHAR(20) NOT NULL,
  cognome VARCHAR(20) NOT NULL,
  cf VARCHAR(16) NOT NULL,
  sesso ENUM('MASCHIO', 'FEMMINA') NOT NULL,
  genere ENUM('MASCHILE', 'FEMMINILE', 'NON BINARIO', 'ALTRO') NOT NULL,
  comunediN VARCHAR(2) NOT NULL,
  datadiN DATE NOT NULL,
  partitaIva VARCHAR(11) NOT NULL,
  tipo VARCHAR ENUM('S.P.A.', 'S.R.L.', 'S.N.C') NOT NULL,
  ragione_sociale VARCHAR(25) NOT NULL,
  indirizzoFisica_id INT NOT NULL,
  indirizzoSede_id INT,
  FOREIGN KEY (generale_id) REFERENCES UtentiGenerali(id_generale),
  FOREIGN KEY (indirizzoFisica_id) REFERENCES IndirizziFisica(id_indirizzo),
  FOREIGN KEY (indirizzoSede_id) REFERENCES Sedi(id_sede)
);

CREATE TABLE Documenti (
  id_documento INT AUTO_INCREMENT PRIMARY KEY,
  tipo VARCHAR(15) NOT NULL,
  numero INT NOT NULL,
  scadenza DATE,
  enteEmissivo VARCHAR(25),
  dataEmissione DATE,
  soggetto_id INT NOT NULL,
  FOREIGN KEY (soggetto_id) REFERENCES UtentiGenerali(id_generale)
);

CREATE TABLE Hobby (
  id_hobby INT AUTO_INCREMENT PRIMARY KEY,
  descrizione VARCHAR(50)
);

CREATE TABLE IndiceHobby (
  id_hobby INT,
  id_soggetto INT,
  PRIMARY KEY (id_hobby, id_soggetto)
);

CREATE TABLE IndirizziFisica (
  id_indirizzo INT AUTO_INCREMENT PRIMARY KEY,
  indiDomicilio VARCHAR(50) NOT NULL,
  indiResidenza VARCHAR(50) NOT NULL
);

CREATE TABLE Sedi(
  id_sede INT AUTO_INCREMENT PRIMARY KEY,
  indirizzo VARCHAR(50) NOT NULL,
  principale BOOLEAN NOT NULL
);

CREATE TABLE NumeriTelefono(
  id_numTel INT AUTO_INCREMENT PRIMARY KEY,
  numero INT NOT NULL,
  soggetto_id INT NOT NULL,
  FOREIGN KEY (soggetto_id) REFERENCES UtentiGenerali(id_generale)
);

CREATE TABLE Ambiti(
  id_ambito INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(25) NOT NULL,
);

CREATE TABLE IndiceAmbiti(
  id_ambito INT,
  id_soggetto INT,
  PRIMARY KEY(id_ambito, id_soggetto)
);

CREATE TABLE UtentiGenerali (
  id_generale INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(20) NOT NULL,
  email UNIQUE VARCHAR(30),
  password VARCHAR(20) NOT NULL,
  tipo ENUM('FISICA', 'GIURIDICA', 'INDIVIDUALE') NOT NULL,
  cancellato BOOLEAN NOT NULL
);