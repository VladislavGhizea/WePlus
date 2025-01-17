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
const Individuali = [...Fisiche, ...Giuridiche];

export { Fisiche, Giuridiche, Individuali };
