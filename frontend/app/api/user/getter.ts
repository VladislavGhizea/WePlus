import { SERVER } from "../../variables";

interface User {
  soggetto_id: number;
  username: string;
  email: string;
  password: string;
  tipo: "FISICA" | "GIURIDICA" | "INDIVIDUALE" | "ADMIN";
  cancellato: boolean;
}

async function fetchUsers(controller: AbortController): Promise<User[]> {
  const response = await fetch(`${SERVER}/utentiGenerali`, {
    signal: controller.signal,
  });

  if (!response.ok) {
    throw new Error(`Network response was not ok: ${response.statusText}`);
  }

  const users = await response.json();

  if (!Array.isArray(users)) {
    throw new Error("Response is not an array");
  }

  return users;
}

async function getUserIdByUsername(username: string): Promise<number> {
  const TIMEOUT = 5000; // Timeout di 5 secondi

  const controller = new AbortController();
  const timeoutId = setTimeout(() => controller.abort(), TIMEOUT);

  try {
    const users = await fetchUsers(controller);
    clearTimeout(timeoutId);

    const user = users.find((user) => user.username === username);

    if (user && user.soggetto_id) {
      return user.soggetto_id;
    } else {
      throw new Error("User not found or invalid user object");
    }
  } catch (error) {
    if (error instanceof DOMException && error.name === "AbortError") {
      console.error("Request timed out");
    } else {
      console.error("There was a problem with the fetch operation:", error);
    }
    throw error;
  }
}

export { getUserIdByUsername };
