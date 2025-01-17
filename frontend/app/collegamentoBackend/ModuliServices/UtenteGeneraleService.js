import fetchWrapper from './fetchWrapper';

// Recupera tutti gli utenti generali
export const getAllUtentiGenerali = async () => {
  return await fetchWrapper('/UtentiGenerali');
};

// Recupera un utente generale per ID
export const getUtenteGeneraleById = async (id) => {
  return await fetchWrapper(`/UtentiGenerali/${id}`);
};

// Crea un nuovo utente generale
export const createUtenteGenerale = async (utenteGenerale) => {
  return await fetchWrapper('/UtentiGenerali', {
    method: 'POST',
    body: JSON.stringify(utenteGenerale),
  });
};

// Aggiorna un utente generale esistente
export const updateUtenteGenerale = async (id, utenteGenerale) => {
  return await fetchWrapper(`/UtentiGenerali/${id}`, {
    method: 'PUT',
    body: JSON.stringify(utenteGenerale),
  });
};

// Elimina un utente generale
export const deleteUtenteGenerale = async (id) => {
  return await fetchWrapper(`/UtentiGenerali/${id}`, {
    method: 'DELETE',
  });
};
