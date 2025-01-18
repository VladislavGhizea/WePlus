import fetchWrapper from "../fetchWrapper";

interface Sede {
  // Definisci qui le proprietà dell'interfaccia Sede
  id?: number;
  nome: string;
  indirizzo: string;
  citta: string;
  cap: string;
  provincia: string;
  stato: string;
}

// Recupera tutte le sedi
export const getAllSedi = async (): Promise<Sede[]> => {
  return (await fetchWrapper("/Sedi")) as Sede[];
};

// Recupera una sede per ID
export const getSedeById = async (id: number): Promise<Sede> => {
  return (await fetchWrapper(`/Sedi/${id}`)) as Sede;
};

// Crea una nuova sede
export const createSede = async (sede: Sede): Promise<Sede> => {
  return (await fetchWrapper("/Sedi", {
    method: "POST",
    body: JSON.stringify(sede),
  })) as Sede;
};

// Aggiorna una sede esistente
export const updateSede = async (id: number, sede: Sede): Promise<Sede> => {
  return (await fetchWrapper(`/Sedi/${id}`, {
    method: "PUT",
    body: JSON.stringify(sede),
  })) as Sede;
};

// Elimina una sede
export const deleteSede = async (id: number): Promise<void> => {
  await fetchWrapper(`/Sedi/${id}`, {
    method: "DELETE",
  });
};
