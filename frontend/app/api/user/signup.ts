import { SERVER } from "../../variables";
import bcrypt from "bcryptjs";

// Interfaccia per definire la struttura di un utente
interface User {
  soggetto_id: number;
  username: string;
  email: string;
  password: string;
  tipo: "FISICA" | "GIURIDICA" | "INDIVIDUALE" | "ADMIN";
  cancellato: boolean;
}

// Interfaccia per definire i valori di input necessari per la funzione di signup
interface InputValues {
  username: string;
  email: string;
  password: string;
  confirmPassword: string;
  tipo: "FISICA" | "GIURIDICA" | "INDIVIDUALE" | "ADMIN";
}

interface SignupResponse {
  success: boolean;
  error?: string;
  user?: User;
}

// Funzione di validazione dell'email
const isValidEmail = (email: string): boolean => {
  const exp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  return exp.test(email);
};

// Funzione per verificare i campi richiesti
const areRequiredFieldsPresent = (
  username: string,
  email: string,
  password: string
): boolean => {
  return !!username && !!email && !!password;
};

// Funzione di signup
const signup = async ({
  username,
  email,
  password,
  confirmPassword,
  tipo,
}: InputValues): Promise<SignupResponse> => {
  if (password !== confirmPassword) {
    return { success: false, error: "Le password non corrispondono" };
  }

  // Verifica che username, email e password siano presenti
  if (!areRequiredFieldsPresent(username, email, password)) {
    return {
      success: false,
      error: "Username, email e password sono richiesti",
    };
  }

  // Verifica che l'email sia valida
  if (!isValidEmail(email)) {
    return { success: false, error: "Email non valida" };
  }

  try {
    // Hash della password
    const hashedPassword = await bcrypt.hash(password, 10);

    // Invia una richiesta POST al server con i dati dell'utente
    const response = await fetch(`${SERVER}/utentiGenerali`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, email, password: hashedPassword, tipo }),
    });

    // Se la risposta non è ok, ritorna un errore
    if (!response.ok) {
      const errorData = await response.json();
      return {
        success: false,
        error: errorData.message || "Credenziali non valide",
      };
    }

    // Estrae i dati dalla risposta
    const data: User = await response.json();

    // Ritorna i dati dell'utente
    return { success: true, user: data };
  } catch (error) {
    // In caso di errore durante la richiesta, ritorna un errore di connessione
    return {
      success: false,
      error: String(error) || "Errore di connessione al server",
    };
  }
};

export default signup;
