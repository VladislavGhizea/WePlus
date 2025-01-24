import { SERVER } from "../../variables";
import { Fisica, Giuridica, Individuale } from "../../variables/entities";

interface CreateUserInput {
  utenteGeneraleId: number;
  nome?: string;
  cognome?: string;
  cf?: string;
  sesso?: "MASCHIO" | "FEMMINA";
  genere?: "MASCHILE" | "FEMMINILE" | "NON_BINARIO" | "ALTRO";
  comuneDiN?: string;
  dataDiN?: string;
  indirizzoFisicaId?: number;
  partitaIva?: string;
  tipo?: "SRL" | "SPA" | "SNC";
  ragioneSociale?: string;
}

interface CreateUserResponse {
  success: boolean;
  error?: string;
  user?: Fisica | Giuridica | Individuale;
}

const createIndirizzoFisico = async (
  userData: CreateUserInput
): Promise<number | null> => {
  const indirizzoResponse = await fetch(`${SERVER}/indirizziFisici`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      indiDomicilio: userData.indirizzoFisicaId,
      indiResidenza: userData.indirizzoFisicaId,
      soggettoId: userData.utenteGeneraleId,
    }),
  });

  if (!indirizzoResponse.ok) {
    const errorData = await indirizzoResponse.json();
    throw new Error(
      errorData.message || "Errore nella creazione dell'indirizzo fisico"
    );
  }

  const indirizzoData = await indirizzoResponse.json();
  return indirizzoData.id;
};

const determineUserType = (
  userData: CreateUserInput
): Fisica | Giuridica | Individuale => {
  if (userData.cf && userData.partitaIva) {
    return new Individuale(
      userData.utenteGeneraleId,
      userData.nome!,
      userData.cognome!,
      userData.cf,
      userData.sesso!,
      userData.genere!,
      userData.comuneDiN!,
      userData.dataDiN!,
      userData.indirizzoFisicaId!,
      userData.partitaIva,
      userData.ragioneSociale!
    );
  } else if (userData.cf) {
    return new Fisica(
      userData.nome!,
      userData.cognome!,
      userData.cf,
      userData.sesso!,
      userData.genere!,
      userData.comuneDiN!,
      userData.dataDiN!,
      userData.indirizzoFisicaId!
    );
  } else if (userData.partitaIva) {
    return new Giuridica(
      userData.partitaIva,
      userData.tipo!,
      userData.ragioneSociale!
    );
  } else {
    throw new Error("Dati insufficienti per determinare il tipo di utente");
  }
};

const createUser = async (
  userData: CreateUserInput
): Promise<CreateUserResponse> => {
  try {
    if (userData.cf) {
      const indirizzoId = await createIndirizzoFisico(userData);
      if (indirizzoId !== null) {
        userData.indirizzoFisicaId = indirizzoId;
      } else {
        throw new Error("Errore nella creazione dell'indirizzo fisico");
      }
    }

    const userType = determineUserType(userData);

    const response = await fetch(`${SERVER}/specificUser/createUser`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(userType),
    });

    if (!response.ok) {
      const errorData = await response.json();
      return {
        success: false,
        error: errorData.message || "Errore nella creazione dell'utente",
      };
    }

    const data = await response.json();
    return { success: true, user: data };
  } catch (error) {
    return {
      success: false,
      error: (error as Error).message || "Errore di connessione al server",
    };
  }
};

export default createUser;
