// array di valori di input delle persone fisiche
const Fisiche = [
  { text: "Nome", type: "text" },
  { text: "Cognome", type: "text" },
  { text: "Codice Fiscale", type: "text" },
  { text: "Sesso", type: "select", options: ["M", "F"] },
  {
    text: "Genere",
    type: "select",
    options: ["Maschile", "Femminile", "Non Binario", "Altro"],
  },
  { text: "Comune di Nascita", type: "text" },
  { text: "Data di Nascita", type: "date" },
  { text: "Indirizzo di Domicilio", type: "text" },
  { text: "Indirizzo di Residenza", type: "text" },
];

// array di valori di input delle persone giuridiche
const Giuridiche = [
  { text: "P.IVA", type: "text" },
  {
    text: "Tipo Società",
    type: "select",
    options: ["S.p.A.", "S.r.L.", "S.n.C."],
  },
  { text: "Ragione Sociale", type: "text" },
  { text: "Sede", type: "text" },
  { text: "Principale", type: "checkbox" },
];

// array di valori di input delle entità individuali
const Individuali = [...Fisiche, ...Giuridiche].filter(
  (input) => input.text !== "Tipo Società"
);

export { Fisiche, Giuridiche, Individuali };

// Interfaccia per le entità individuali
interface TypeIndividuale {
  utenteGeneraleId: number;
  nome: string;
  cognome: string;
  cf: string;
  sesso: "MASCHIO" | "FEMMINA";
  genere: "MASCHILE" | "FEMMINILE" | "NON_BINARIO" | "ALTRO";
  comuneDiN: string;
  dataDiN: string;
  indirizzoFisicaId: number;
  partitaIva: string;
  ragioneSociale: string;
}

// Classe per le entità individuali
class Individuale implements TypeIndividuale {
  utenteGeneraleId: number;
  nome: string;
  cognome: string;
  cf: string;
  sesso: "MASCHIO" | "FEMMINA";
  genere: "MASCHILE" | "FEMMINILE" | "NON_BINARIO" | "ALTRO";
  comuneDiN: string;
  dataDiN: string;
  indirizzoFisicaId: number;
  partitaIva: string;
  ragioneSociale: string;

  constructor(
    utenteGeneraleId: number,
    nome: string,
    cognome: string,
    cf: string,
    sesso: "MASCHIO" | "FEMMINA",
    genere: "MASCHILE" | "FEMMINILE" | "NON_BINARIO" | "ALTRO",
    comuneDiN: string,
    dataDiN: string,
    indirizzoFisicaId: number,
    partitaIva: string,
    ragioneSociale: string
  ) {
    this.utenteGeneraleId = utenteGeneraleId;
    this.nome = nome;
    this.cognome = cognome;
    this.cf = cf;
    this.sesso = sesso;
    this.genere = genere;
    this.comuneDiN = comuneDiN;
    this.dataDiN = dataDiN;
    this.indirizzoFisicaId = indirizzoFisicaId;
    this.partitaIva = partitaIva;
    this.ragioneSociale = ragioneSociale;
  }
}

// Interfaccia per le sedi
interface TypeSede {
  entitaIndividualeId?: number;
  personaGiuridicaId?: number;
  indirizzo: string;
  principale: boolean;
}

// Classe per le sedi
class Sede implements TypeSede {
  entitaIndividualeId?: number;
  personaGiuridicaId?: number;
  indirizzo: string;
  principale: boolean;

  //NON siamo sicuri che i campi saranno pieni(passo un oggetto con dentro campi potenzialmente null)
  constructor(options: {
    entitaIndividualeId?: number;
    personaGiuridicaId?: number;
    indirizzo: string;
    principale: boolean;
  }) {
    if (options.entitaIndividualeId && options.personaGiuridicaId) {
      throw new Error(
        "Puoi specificare solo uno tra entitaIndividualeId e personaGiuridicaId"
      );
    }
    if (!options.entitaIndividualeId && !options.personaGiuridicaId) {
      throw new Error(
        "Devi specificare almeno uno tra entitaIndividualeId e personaGiuridicaId"
      );
    }

    this.entitaIndividualeId = options.entitaIndividualeId;
    this.personaGiuridicaId = options.personaGiuridicaId;
    this.indirizzo = options.indirizzo;
    this.principale = options.principale;
  }
}

// Interfaccia per gli indirizzi fisici
interface TypeIndirizzoFisica {
  indiDomicilio: string;
  indiResidenza: string;
  soggettoId: number;
}

// Classe per gli indirizzi fisici
class IndirizzoFisica implements TypeIndirizzoFisica {
  indiDomicilio: string;
  indiResidenza: string;
  soggettoId: number;

  //siamo sicuri che i campi saranno pieni
  constructor(
    indiDomicilio: string,
    indiResidenza: string,
    soggettoId: number
  ) {
    this.indiDomicilio = indiDomicilio;
    this.indiResidenza = indiResidenza;
    this.soggettoId = soggettoId;
  }
}

// Interfaccia per le persone fisiche
interface TypeFisica {
  utenteGeneraleId: number;
  nome: string;
  cognome: string;
  cf: string;
  sesso: "MASCHIO" | "FEMMINA";
  genere: "MASCHILE" | "FEMMINILE" | "NON_BINARIO" | "ALTRO";
  comuneDiN: string;
  dataDiN: string;
  indirizzoFisicaId: number;
}

// Classe per le persone fisiche
class Fisica implements TypeFisica {
  utenteGeneraleId: number;
  nome: string;
  cognome: string;
  cf: string;
  sesso: "MASCHIO" | "FEMMINA";
  genere: "MASCHILE" | "FEMMINILE" | "NON_BINARIO" | "ALTRO";
  comuneDiN: string;
  dataDiN: string;
  indirizzoFisicaId: number;

  constructor(
    utenteGeneraleId: number,
    nome: string,
    cognome: string,
    cf: string,
    sesso: "MASCHIO" | "FEMMINA",
    genere: "MASCHILE" | "FEMMINILE" | "NON_BINARIO" | "ALTRO",
    comuneDiN: string,
    dataDiN: string,
    indirizzoFisicaId: number
  ) {
    this.utenteGeneraleId = utenteGeneraleId;
    this.nome = nome;
    this.cognome = cognome;
    this.cf = cf;
    this.sesso = sesso;
    this.genere = genere;
    this.comuneDiN = comuneDiN;
    this.dataDiN = dataDiN;
    this.indirizzoFisicaId = indirizzoFisicaId;
  }
}

// Interfaccia per le persone giuridiche
interface TypeGiuridica {
  utenteGeneraleId: number;
  partitaIva: string;
  tipo: "SRL" | "SPA" | "SNC";
  ragioneSociale: string;
  sede?: number;
}

// Classe per le persone giuridiche
class Giuridica implements TypeGiuridica {
  utenteGeneraleId: number;
  partitaIva: string;
  tipo: "SRL" | "SPA" | "SNC";
  ragioneSociale: string;
  sede?: number;

  constructor(
    utenteGeneraleId: number,
    partitaIva: string,
    tipo: "SRL" | "SPA" | "SNC",
    ragioneSociale: string,
    sede?: number
  ) {
    this.utenteGeneraleId = utenteGeneraleId;
    this.partitaIva = partitaIva;
    this.tipo = tipo;
    this.ragioneSociale = ragioneSociale;
    this.sede = sede;
  }
}

export { Sede, IndirizzoFisica, Fisica, Giuridica, Individuale };
