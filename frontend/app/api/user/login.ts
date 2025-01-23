import { SERVER } from "../../variables";
import bcrypt from "bcryptjs";

interface User {
  soggetto_id: number;
  username: string;
  email: string;
  password: string;
  tipo: "FISICA" | "GIURIDICA" | "INDIVIDUALE" | "ADMIN";
  cancellato: boolean;
}

export const login = async (
  username: string,
  password: string
): Promise<{ success: boolean; user?: any; error?: string }> => {
  if (!username || !password) {
    return { success: false, error: "Username e password sono richiesti" };
  }

  try {
    const response = await fetch(`${SERVER}/login`, {
      method: "POST",
      mode: "no-cors",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username }),
    });

    if (!response.ok) {
      // Se la risposta non è ok ritorna un errore
      const errorData = await response.json();
      return {
        success: false,
        error: errorData.message || "Credenziali non valide",
      };
    }

    const data: User = await response.json();

    // Confronta la password hashata
    // const isPasswordValid = await bcrypt.compare(password, data.password);
    // if (!isPasswordValid) {
    //   return { success: false, error: "Credenziali non valide" };
    // }
    console.log(data);
    return { success: true, user: data };
  } catch (error) {
    return { success: false, error: "Errore di connessione al server" };
  }
};
