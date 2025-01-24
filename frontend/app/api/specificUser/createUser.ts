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
  user?: any;
}
//post generalUser, post indriziFisica?, post specificUser
const createUser = async (
  userData: CreateUserInput
): Promise<CreateUserResponse> => {
  try {
    // Crea l'indirizzo fisico se necessario
    if (userData.cf) {
      const indirizzoResponse = await fetch(`${SERVER}/indirizziFisici`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          indiDomicilio: userData.indirizzoFisicaId,
          indiResidenza: userData.indirizzoFisicaId,
          soggettoId: userData.utenteGeneraleId, //!PASSARE L'UTENTE GENERALE
        }),
      });

      if (!indirizzoResponse.ok) {
        const errorData = await indirizzoResponse.json();
        return {
          success: false,
          error:
            errorData.message || "Errore nella creazione dell'indirizzo fisico",
        };
      }

      const indirizzoData = await indirizzoResponse.json();
      userData.indirizzoFisicaId = indirizzoData.id;
    }

    // Determina il tipo di utente
    let userType;
    if (userData.cf && userData.partitaIva) {
      userType = new Individuale(
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
      userType = new Fisica(
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
      userType = new Giuridica(
        userData.partitaIva,
        userData.tipo!,
        userData.ragioneSociale!
      );
    } else {
      return {
        success: false,
        error: "Dati insufficienti per determinare il tipo di utente",
      };
    }

    // Invia una richiesta POST al server con i dati dell'utente
    const response = await fetch(`${SERVER}/specificUser/createUser`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(userType), //! CAMBIARE CAZZOOOOOOOOOOOOOO
    });

    // Se la risposta non è ok, ritorna un errore
    if (!response.ok) {
      const errorData = await response.json();
      return {
        success: false,
        error: errorData.message || "Errore nella creazione dell'utente",
      };
    }

    // Estrae i dati dalla risposta
    const data = await response.json();

    // Ritorna i dati dell'utente creato
    return { success: true, user: data };
  } catch (error) {
    // In caso di errore durante la richiesta, ritorna un errore di connessione
    return { success: false, error: "Errore di connessione al server" };
  }
};

export default createUser;
