import { SERVER } from "../../variables";

interface User {
  soggetto_id: number;
  username: string;
  email: string;
  password: string;
  tipo: "FISICA" | "GIURIDICA" | "INDIVIDUALE" | "ADMIN";
  cancellato: boolean;
}

async function getUserIdByUsername(username: string): Promise<number> {
  const TIMEOUT = 5000; // Timeout di 5 secondi

  const controller = new AbortController();
  const timeoutId = setTimeout(() => controller.abort(), TIMEOUT);

  try {
    const response = await fetch(`${SERVER}/utentiGenerali`, {
      signal: controller.signal,
    });
    clearTimeout(timeoutId);

    if (!response.ok) {
      throw new Error(`Network response was not ok: ${response.statusText}`);
    }

    const users = await response.json();

    if (!Array.isArray(users)) {
      throw new Error("Response is not an array");
    }

    const user = users.find((user) => user.username === username);

    if (user && user.id) {
      return user.id;
    } else {
      throw new Error("User not found or invalid user object");
    }
  } catch (error: any) {
    if (error.name === "AbortError") {
      console.error("Request timed out");
    } else {
      console.error("There was a problem with the fetch operation:", error);
    }
    throw error;
  }
}
