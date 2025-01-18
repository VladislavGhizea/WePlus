import fetchWrapper from '../fetchWrapper';

interface UtenteGenerale {
  // Definisci qui le proprietà dell'interfaccia UtenteGenerale
  id?: number;
  nome: string;
  cognome: string;
  email: string;
  password: string;
}

// Recupera tutti gli utenti generali
export const getAllUtentiGenerali = async (): Promise<UtenteGenerale[]> => {
  return await fetchWrapper('/UtentiGenerali') as UtenteGenerale[];
};

// Recupera un utente generale per ID
export const getUtenteGeneraleById = async (id: number): Promise<UtenteGenerale> => {
  return await fetchWrapper(`/UtentiGenerali/${id}`) as UtenteGenerale;
};

// Crea un nuovo utente generale
export const createUtenteGenerale = async (utenteGenerale: UtenteGenerale): Promise<UtenteGenerale> => {
  return await fetchWrapper('/UtentiGenerali', {
    method: 'POST',
    body: JSON.stringify(utenteGenerale),
  }) as UtenteGenerale;
};

// Aggiorna un utente generale esistente
export const updateUtenteGenerale = async (id: number, utenteGenerale: UtenteGenerale): Promise<UtenteGenerale> => {
  return await fetchWrapper(`/UtentiGenerali/${id}`, {
    method: 'PUT',
    body: JSON.stringify(utenteGenerale),
  }) as UtenteGenerale;
};

// Elimina un utente generale
export const deleteUtenteGenerale = async (id: number): Promise<void> => {
  await fetchWrapper(`/UtentiGenerali/${id}`, {
    method: 'DELETE',
  });
};