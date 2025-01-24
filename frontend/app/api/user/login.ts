import { SERVER } from "../../variables";
import bcrypt from "bcryptjs";
import { setCookie } from "nookies";

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
): Promise<{ success: boolean; error?: string }> => {
  if (!username || !password) {
    return { success: false, error: "Username e password sono richiesti" };
  }

  try {
    const response = await fetch(`${SERVER}/login`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS",
        "Access-Control-Allow-Headers": "Content-Type, Authorization",
      },
      body: JSON.stringify({
        username,
        password,
      }),
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

    // const isPasswordValid = await bcrypt.compare(password, data.password);
    // if (!isPasswordValid) {
    //   return { success: false, error: "Credenziali non valide" };
    // }

    // Imposta il cookie con i dati dell'utente
    setCookie(null, "user", JSON.stringify(data), {
      maxAge: 30 * 24 * 60 * 60, // 30 giorni
      path: "/",
    });

    return { success: true };
  } catch (error) {
    return {
      success: false,
      error: (error as Error).message || "Errore di connessione al server",
    };
  }
};
