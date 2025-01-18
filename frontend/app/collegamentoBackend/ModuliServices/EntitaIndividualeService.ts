import fetchWrapper from "../fetchWrapper";

interface EntitaIndividuale {
  // Definisci qui le proprietà dell'interfaccia EntitaIndividuale
  id?: number;
  nome: string;
  cognome: string;
  codiceFiscale: string;
  sesso: string;
  genere: string;
  comuneDiNascita: string;
  dataDiNascita: string;
  indirizzoDiDomicilio: string;
  indirizzoDiResidenza: string;
  pIva?: string;
  tipoSocieta?: string;
  ragioneSociale?: string;
  sede?: string;
  principale?: boolean;
}

// Recupera tutte le entità individuali
export const getAllEntitaIndividuali = async (): Promise<
  EntitaIndividuale[]
> => {
  return (await fetchWrapper("/EntitaIndividuali")) as EntitaIndividuale[];
};

// Recupera un'entità individuale per ID
export const getEntitaIndividualeById = async (
  id: number
): Promise<EntitaIndividuale> => {
  return (await fetchWrapper(`/EntitaIndividuali/${id}`)) as EntitaIndividuale;
};

// Crea una nuova entità individuale
export const createEntitaIndividuale = async (
  entita: EntitaIndividuale
): Promise<EntitaIndividuale> => {
  return (await fetchWrapper("/EntitaIndividuali", {
    method: "POST",
    body: JSON.stringify(entita),
  })) as EntitaIndividuale;
};

// Aggiorna un'entità individuale esistente
export const updateEntitaIndividuale = async (
  id: number,
  entita: EntitaIndividuale
): Promise<EntitaIndividuale> => {
  return (await fetchWrapper(`/EntitaIndividuali/${id}`, {
    method: "PUT",
    body: JSON.stringify(entita),
  })) as EntitaIndividuale;
};

// Elimina un'entità individuale
export const deleteEntitaIndividuale = async (id: number): Promise<void> => {
  await fetchWrapper(`/EntitaIndividuali/${id}`, {
    method: "DELETE",
  });
};
